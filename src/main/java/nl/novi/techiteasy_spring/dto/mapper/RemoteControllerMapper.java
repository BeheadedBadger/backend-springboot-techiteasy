package nl.novi.techiteasy_spring.dto.mapper;

import nl.novi.techiteasy_spring.dto.input.RemoteControllerInputDto;
import nl.novi.techiteasy_spring.dto.output.RemoteControllerOutPutDto;
import nl.novi.techiteasy_spring.models.RemoteController;

public class RemoteControllerMapper {
    public static RemoteController fromInputDtoToModel(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController r = new RemoteController();
        r.setCompatibleWith(remoteControllerInputDto.compatibleWith);
        r.setBatteryType(remoteControllerInputDto.batteryType);
        r.setName(remoteControllerInputDto.name);
        r.setBrand(remoteControllerInputDto.brand);
        r.setPrice(remoteControllerInputDto.price);
        r.setOriginalStock(remoteControllerInputDto.originalStock);
        return r;
    }

    public static RemoteControllerOutPutDto fromModeltoOutputDto(RemoteController remoteController) {
        RemoteControllerOutPutDto r = new RemoteControllerOutPutDto();
        r.setId(remoteController.getId());
        r.setCompatibleWith(remoteController.getCompatibleWith());
        r.setBatteryType(remoteController.getBatteryType());
        r.setName(remoteController.getName());
        r.setBrand(remoteController.getBrand());
        r.setPrice(remoteController.getPrice());
        r.setOriginalStock(remoteController.getOriginalStock());

        return r;
    }
}
