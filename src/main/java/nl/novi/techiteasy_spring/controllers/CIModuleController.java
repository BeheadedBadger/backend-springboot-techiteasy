package nl.novi.techiteasy_spring.controllers;
import jakarta.validation.Valid;
import nl.novi.techiteasy_spring.dto.input.CIModuleInputDto;
import nl.novi.techiteasy_spring.dto.output.CIModuleOutPutDto;
import nl.novi.techiteasy_spring.service.CIModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

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

    @PutMapping("/{ciModuleId}/televisions/{televisionId}")
    public ResponseEntity<String> assignTelevisionToCIModule(@PathVariable Long televisionId, @PathVariable Long ciModuleId) {
        this.ciModuleService.assignTelevision(ciModuleId, televisionId);
        return ResponseEntity.ok("CIModule " + ciModuleId + " linked with television " + televisionId);
    }

    @GetMapping
    public ResponseEntity<List<CIModuleOutPutDto>> getAllCIModules() {
        return ResponseEntity.ok(ciModuleService.GetAllCIModules());
    }

    @GetMapping("/{ciModuleId}")
    public ResponseEntity<CIModuleOutPutDto> getCIModuleById(@PathVariable Long ciModuleId) {
        return ResponseEntity.ok(ciModuleService.GetCIModuleById(ciModuleId));
    }

    //Delete
}
