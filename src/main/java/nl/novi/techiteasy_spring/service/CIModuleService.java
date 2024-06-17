package nl.novi.techiteasy_spring.service;
import nl.novi.techiteasy_spring.dto.input.CIModuleInputDto;
import nl.novi.techiteasy_spring.dto.mapper.CIModuleMapper;
import nl.novi.techiteasy_spring.dto.output.CIModuleOutPutDto;
import nl.novi.techiteasy_spring.models.CIModule;
import nl.novi.techiteasy_spring.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;

@Service
public class CIModuleService {
    private final CIModuleRepository repo;

    public CIModuleService(CIModuleRepository ciModuleRepository) {
        this.repo = ciModuleRepository;
    }

    public CIModuleOutPutDto createCIModule(CIModuleInputDto ciModuleInputDto) {
        CIModule ci = repo.save(CIModuleMapper.fromInputDtoToModel(ciModuleInputDto));
        return CIModuleMapper.fromModelToOutputDto(ci);
    }
}
