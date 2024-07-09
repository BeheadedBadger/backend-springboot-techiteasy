package nl.novi.techiteasy_spring.repositories;
import nl.novi.techiteasy_spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}