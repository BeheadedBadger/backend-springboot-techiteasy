package nl.novi.techiteasy_spring.dto.mapper;
import nl.novi.techiteasy_spring.dto.input.TelevisionInputDto;
import nl.novi.techiteasy_spring.dto.output.TelevisionOutputDto;
import nl.novi.techiteasy_spring.models.Television;

public class TelevisionMapper {
    public static Television fromInputDtoToModel (TelevisionInputDto televisionInputDto) {
        Television t = new Television();
        t.setType(televisionInputDto.type);
        t.setBrand(televisionInputDto.brand);
        t.setName(televisionInputDto.name);
        t.setPrice(televisionInputDto.price);
        t.setAvailableSize(televisionInputDto.availableSize);
        t.setRefreshRate(televisionInputDto.refreshRate);
        t.setScreenType(televisionInputDto.screenType);
        t.setScreenQuality(televisionInputDto.screenQuality);
        t.setSmartTv(televisionInputDto.smartTv);
        t.setWifi(televisionInputDto.wifi);
        t.setVoiceControl(televisionInputDto.voiceControl);
        t.setHdr(televisionInputDto.hdr);
        t.setBluetooth(televisionInputDto.bluetooth);
        t.setAmbiLight(televisionInputDto.ambiLight);

        return t;
    }

    public static TelevisionOutputDto fromModelToOutputDto (Television television) {
        TelevisionOutputDto t = new TelevisionOutputDto();

        t.setId(television.getId());
        t.setType(television.getType());
        t.setBrand(television.getBrand());
        t.setName(television.getName());
        t.setPrice(television.getPrice());
        t.setAvailableSize(television.getAvailableSize());
        t.setRefreshRate(television.getRefreshRate());
        t.setScreenType(television.getScreenType());
        t.setScreenQuality(television.getScreenQuality());
        t.setSmartTv(television.getSmartTv());
        t.setWifi(television.getWifi());
        t.setVoiceControl(television.getVoiceControl());
        t.setHdr(television.getHdr());
        t.setBluetooth(television.getBluetooth());
        t.setAmbiLight(television.getAmbiLight());
        return t;
    }
}