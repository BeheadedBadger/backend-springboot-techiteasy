package nl.novi.techiteasy_spring.dto.mapper;

import nl.novi.techiteasy_spring.dto.input.WallBracketInputDto;
import nl.novi.techiteasy_spring.dto.output.WallBracketOutPutDto;
import nl.novi.techiteasy_spring.models.WallBracket;

public class WallBracketMapper {
    public static WallBracket fromInputDtoToModel(WallBracketInputDto wallBracketInputDto) {
        WallBracket wb = new WallBracket();
        wb.setSize(wallBracketInputDto.size);
        wb.setAdjustable(wallBracketInputDto.adjustable);
        wb.setName(wallBracketInputDto.name);
        wb.setPrice(wallBracketInputDto.price);
        return wb;

    }

    public static WallBracketOutPutDto fromModeltoOutputDto(WallBracket wallBracket) {
        WallBracketOutPutDto wb = new WallBracketOutPutDto();
        wb.setId(wallBracket.getId());
        wb.setSize(wallBracket.getSize());
        wb.setAdjustable(wallBracket.getAdjustable());
        wb.setName(wallBracket.getName());
        wb.setPrice(wallBracket.getPrice());
        return wb;
    }
}
