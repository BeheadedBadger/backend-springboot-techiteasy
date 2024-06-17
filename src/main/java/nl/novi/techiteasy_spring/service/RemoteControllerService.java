package nl.novi.techiteasy_spring.service;
import nl.novi.techiteasy_spring.dto.input.RemoteControllerInputDto;
import nl.novi.techiteasy_spring.dto.mapper.RemoteControllerMapper;
import nl.novi.techiteasy_spring.dto.output.RemoteControllerOutPutDto;
import nl.novi.techiteasy_spring.models.RemoteController;
import nl.novi.techiteasy_spring.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoteControllerService {
    private final RemoteControllerRepository repo;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.repo = remoteControllerRepository;
    }

    public RemoteControllerOutPutDto createRemote(RemoteControllerInputDto inputDto){
        RemoteController r = repo.save(RemoteControllerMapper.fromInputDtoToModel(inputDto));
        return RemoteControllerMapper.fromModeltoOutputDto(r);
    }
}
