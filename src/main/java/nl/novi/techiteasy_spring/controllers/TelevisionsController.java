package nl.novi.techiteasy_spring.controllers;
import jakarta.validation.Valid;
import nl.novi.techiteasy_spring.dto.input.TelevisionInputDto;
import nl.novi.techiteasy_spring.dto.output.TelevisionOutputDto;
import nl.novi.techiteasy_spring.exceptions.InvalidBrandException;
import nl.novi.techiteasy_spring.exceptions.RecordNotFoundException;
import nl.novi.techiteasy_spring.models.Television;
import nl.novi.techiteasy_spring.service.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {

    private final TelevisionService televisionService;

    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @PostMapping
    public ResponseEntity<TelevisionOutputDto> createTelevision(@Valid @RequestBody TelevisionInputDto televisionInputDto) {
        TelevisionOutputDto televisionOutputDto = televisionService.createTelevision(televisionInputDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(televisionOutputDto.getId()).toUri();
        return ResponseEntity.created(uri).body(televisionOutputDto);
    }

    @GetMapping
    public ResponseEntity<List<TelevisionOutputDto>> getAllTelevisions() {
        return ResponseEntity.ok().body(televisionService.GetAllTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> getTelevisionById(@PathVariable long id) {
        return ResponseEntity.ok().body(televisionService.GetTelevisionByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionOutputDto> editTelevisionById(@PathVariable long id, @RequestBody TelevisionInputDto televisionInputDto) {
        return ResponseEntity.ok().body(televisionService.EditTelevisionByID(id, televisionInputDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevisionById(@PathVariable long id) {
        return ResponseEntity.ok().body(televisionService.DeleteTelevisionByID(id));
    }
}