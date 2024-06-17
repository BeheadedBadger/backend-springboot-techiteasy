package nl.novi.techiteasy_spring.dto.mapper;
import nl.novi.techiteasy_spring.dto.input.CIModuleInputDto;
import nl.novi.techiteasy_spring.dto.output.CIModuleOutPutDto;
import nl.novi.techiteasy_spring.models.CIModule;

public class CIModuleMapper {
    public static CIModule fromInputDtoToModel (CIModuleInputDto ciModuleInputDto) {
        CIModule ci = new CIModule();
        ci.setName(ciModuleInputDto.name);
        ci.setType(ciModuleInputDto.type);
        ci.setPrice(ciModuleInputDto.price);
        return ci;
    }

    public static CIModuleOutPutDto fromModelToOutputDto (CIModule ciModule) {
        CIModuleOutPutDto ci = new CIModuleOutPutDto();
        ci.setId(ciModule.getId());
        ci.setName(ciModule.getName());
        ci.setType(ciModule.getType());
        ci.setPrice(ciModule.getPrice());
        return ci;
    }
}