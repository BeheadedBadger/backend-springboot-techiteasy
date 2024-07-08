package nl.novi.techiteasy_spring.service;
import nl.novi.techiteasy_spring.dto.UserDto;
import nl.novi.techiteasy_spring.exceptions.UsernameNotFoundException;
import nl.novi.techiteasy_spring.models.Authority;
import nl.novi.techiteasy_spring.models.User;
import nl.novi.techiteasy_spring.repositories.AuthorityRepository;
import nl.novi.techiteasy_spring.repositories.UserRepository;
import nl.novi.techiteasy_spring.utils.RandomStringGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    UserRepository userRepository;
    AuthorityRepository authorityRepository;

    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(fromUser(user));
        }
        return collection;
    }

    public UserDto getUser(String username) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById(Long.valueOf(username));
        if (user.isPresent()){
            dto = fromUser(user.get());
        }else {
            throw new UsernameNotFoundException(username);
        }
        return dto;
    }

    public boolean userExists(String username) {
        return userRepository.existsById(Long.valueOf(username));
    }

    public String createUser(UserDto userDto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userDto.setApikey(randomString);
        User newUser = userRepository.save(toUser(userDto));
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(Long.valueOf(username));
    }

    public void updateUser(String username, UserDto newUser) {
        if (!userRepository.existsById(Long.valueOf(username))) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(Long.valueOf(username)).get();
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(Long.valueOf(username))) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(Long.valueOf(username)).get();
        UserDto userDto = fromUser(user);
        return userDto.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(Long.valueOf(username)) && authorityRepository.existsAuthorityByAuthority(authority)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(Long.valueOf(username)).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(Long.valueOf(username))) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(Long.valueOf(username)).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

    public static UserDto fromUser(User user){

        var dto = new UserDto();

        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.apikey = user.getApikey();
        dto.email = user.getEmail();
        dto.authorities = user.getAuthorities();

        return dto;
    }

    public User toUser(UserDto userDto) {

        var user = new User();

        user.setUsername(userDto.getUsername());
        user.setPassword(encode(userDto.getPassword()));
        user.setEnabled(userDto.getEnabled());
        user.setApikey(userDto.getApikey());
        user.setEmail(userDto.getEmail());

        return user;
    }

    public String encode(String passWord) {
        BCryptPasswordEncoder bCryptPasswordEncoder =
                new BCryptPasswordEncoder(10, new SecureRandom());
        return bCryptPasswordEncoder.encode(passWord);
    }

}