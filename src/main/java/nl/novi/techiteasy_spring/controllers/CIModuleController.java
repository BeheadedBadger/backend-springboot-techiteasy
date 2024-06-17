package nl.novi.techiteasy_spring.controllers;
import jakarta.validation.Valid;
import nl.novi.techiteasy_spring.dto.input.CIModuleInputDto;
import nl.novi.techiteasy_spring.dto.output.CIModuleOutPutDto;
import nl.novi.techiteasy_spring.service.CIModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/cimodules")
public class CIModuleController {
    private final CIModuleService ciModuleService;

    public CIModuleController(CIModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @PostMapping
    public ResponseEntity<CIModuleOutPutDto> createCIModule(@Valid @RequestBody CIModuleInputDto inputDto) {
        CIModuleOutPutDto outPutDto = ciModuleService.createCIModule(inputDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(outPutDto.getId()).toUri();
        return ResponseEntity.created(uri).body(outPutDto);
    }
}
