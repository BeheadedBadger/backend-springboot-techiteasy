package nl.novi.techiteasy_spring.controllers;

import jakarta.validation.Valid;
import nl.novi.techiteasy_spring.dto.input.RemoteControllerInputDto;
import nl.novi.techiteasy_spring.dto.output.RemoteControllerOutPutDto;
import nl.novi.techiteasy_spring.service.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/remotecontrollers")
public class RemoteControllerController {
    private final RemoteControllerService remoteControllerService;
    public RemoteControllerController(RemoteControllerService remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }

    @PostMapping
    public ResponseEntity<RemoteControllerOutPutDto> createRemoteController(@Valid @RequestBody RemoteControllerInputDto inputDto) {
        RemoteControllerOutPutDto outPutDto = remoteControllerService.createRemote(inputDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(outPutDto.getId()).toUri();
        return ResponseEntity.created(uri).body(outPutDto);
    }
}