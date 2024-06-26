package nl.novi.techiteasy_spring.controllers;
import jakarta.validation.Valid;
import nl.novi.techiteasy_spring.dto.input.WallBracketInputDto;
import nl.novi.techiteasy_spring.dto.output.WallBracketOutPutDto;
import nl.novi.techiteasy_spring.service.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {
    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @PostMapping
    public ResponseEntity<WallBracketOutPutDto> createWallBracket(@Valid @RequestBody WallBracketInputDto inputDto) {
        WallBracketOutPutDto outPutDto = wallBracketService.createWallBracket(inputDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(outPutDto.getId()).toUri();
        return ResponseEntity.created(uri).body(outPutDto);
    }
}
