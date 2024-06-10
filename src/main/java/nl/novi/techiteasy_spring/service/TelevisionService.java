package nl.novi.techiteasy_spring.service;
import nl.novi.techiteasy_spring.dto.input.TelevisionInputDto;
import nl.novi.techiteasy_spring.dto.mapper.TelevisionMapper;
import nl.novi.techiteasy_spring.dto.output.TelevisionOutputDto;
import nl.novi.techiteasy_spring.exceptions.RecordNotFoundException;
import nl.novi.techiteasy_spring.models.Television;
import nl.novi.techiteasy_spring.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {
    private final TelevisionRepository repo;

    public TelevisionService(TelevisionRepository televisionRepository) {
        this.repo = televisionRepository;
    }

    public TelevisionOutputDto createTelevision(TelevisionInputDto televisionInputDto) {
        Television t = repo.save(TelevisionMapper.fromInputDtoToModel(televisionInputDto));
        return TelevisionMapper.fromModelToOutputDto(t);
    }

    public List<TelevisionOutputDto> GetAllTelevisions() {
        List<Television> televisions = repo.findAll();
        List<TelevisionOutputDto> televisionOutputDtos = new ArrayList<>();

        for (Television t : televisions) {
            televisionOutputDtos.add(TelevisionMapper.fromModelToOutputDto(t));
        }

        return televisionOutputDtos;
    }

    public TelevisionOutputDto GetTelevisionByID(long id) {
        Optional<Television> t = repo.findById(id);
        if (t.isPresent()) {
            return TelevisionMapper.fromModelToOutputDto(t.get());
        } else {
            throw new RecordNotFoundException("No televisions with id " + id + " found");
        }
    }

    public TelevisionOutputDto EditTelevisionByID(long id, TelevisionInputDto televisionInputDto) {
        Optional<Television> t = repo.findById(id);
        if (t.isPresent()) {
            t.get().setName(televisionInputDto.name);
            t.get().setBrand(televisionInputDto.brand);
            t.get().setPrice(televisionInputDto.price);
            repo.save(t.get());
            return TelevisionMapper.fromModelToOutputDto(t.get());
        } else {
            throw new RecordNotFoundException("No televisions with id " + id + " found");
        }
    }

    public String DeleteTelevisionByID(long id) {
        Optional<Television> t = repo.findById(id);
        if (t.isPresent()) {
            repo.delete(t.get());
            return "Removed television with id " + id;
        }
        else {
            throw new RecordNotFoundException("No televisions with id " + id + " found");
        }
    }
}
