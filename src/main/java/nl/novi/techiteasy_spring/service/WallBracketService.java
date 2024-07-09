package nl.novi.techiteasy_spring.service;
import nl.novi.techiteasy_spring.dto.input.WallBracketInputDto;
import nl.novi.techiteasy_spring.dto.mapper.WallBracketMapper;
import nl.novi.techiteasy_spring.dto.output.WallBracketOutPutDto;
import nl.novi.techiteasy_spring.models.WallBracket;
import nl.novi.techiteasy_spring.repositories.RemoteControllerRepository;
import nl.novi.techiteasy_spring.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

@Service
public class WallBracketService {
    private final WallBracketRepository repo;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.repo = wallBracketRepository;
    }

    public WallBracketOutPutDto createWallBracket(WallBracketInputDto inputDto) {
        WallBracket wb = repo.save(WallBracketMapper.fromInputDtoToModel(inputDto));
        return WallBracketMapper.fromModeltoOutputDto(wb);
    }
}
