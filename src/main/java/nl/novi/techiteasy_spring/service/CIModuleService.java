package nl.novi.techiteasy_spring.service;
import nl.novi.techiteasy_spring.dto.input.CIModuleInputDto;
import nl.novi.techiteasy_spring.dto.mapper.CIModuleMapper;
import nl.novi.techiteasy_spring.dto.output.CIModuleOutPutDto;
import nl.novi.techiteasy_spring.exceptions.RecordNotFoundException;
import nl.novi.techiteasy_spring.models.CIModule;
import nl.novi.techiteasy_spring.models.Television;
import nl.novi.techiteasy_spring.repositories.CIModuleRepository;
import nl.novi.techiteasy_spring.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CIModuleService {
    private final CIModuleRepository repo;
    private final TelevisionRepository televisionRepo;

    public CIModuleService(CIModuleRepository ciModuleRepository, TelevisionRepository televisionRepository)
    {
        this.repo = ciModuleRepository;
        this.televisionRepo = televisionRepository;
    }

    public CIModuleOutPutDto createCIModule(CIModuleInputDto ciModuleInputDto) {
        CIModule ci = repo.save(CIModuleMapper.fromInputDtoToModel(ciModuleInputDto));
        return CIModuleMapper.fromModelToOutputDto(ci);
    }

    public void assignTelevision(Long ciModuleId, Long televisionId) {
        Optional<CIModule> ciModule = this.repo.findById(ciModuleId);
        Optional<Television> television = this.televisionRepo.findById(televisionId);

        if (ciModule.isPresent() && television.isPresent()) {
            ciModule.get().setTelevision(television.get());
            this.repo.save(ciModule.get());
        }
        else if (ciModule.isEmpty()) {
            throw new RecordNotFoundException("Cannot find ciModule with id " + ciModuleId);
        }
        else {
            throw new RecordNotFoundException("Cannot find television with id " + televisionId);
        }
    }

    public List<CIModuleOutPutDto> GetAllCIModules() {
        List<CIModule> cimodules = repo.findAll();
        List<CIModuleOutPutDto> ciModuleOutPutDtos = new ArrayList<>();

        for (CIModule ci : cimodules) {
            ciModuleOutPutDtos.add(CIModuleMapper.fromModelToOutputDto(ci));
        }

        return ciModuleOutPutDtos;
    }

    public CIModuleOutPutDto GetCIModuleById(Long ciModuleId) {
        Optional<CIModule> ci = this.repo.findById(ciModuleId);

        if(ci.isPresent()) {
            return CIModuleMapper.fromModelToOutputDto(ci.get());
        }
        else {
            throw new RecordNotFoundException("Cannot find ciModule with id " + ciModuleId);
        }
    }

    public String DeleteCIModuleById(Long ciModuleId) {
        Optional<CIModule> ci = this.repo.findById(ciModuleId);

        if(ci.isPresent()) {
            this.repo.delete(ci.get());
            return "Successfully deleted ciModule with id " + ciModuleId;
        }
        else {
            throw new RecordNotFoundException("Cannot find ciModule with id " + ciModuleId);
        }
    }
}
