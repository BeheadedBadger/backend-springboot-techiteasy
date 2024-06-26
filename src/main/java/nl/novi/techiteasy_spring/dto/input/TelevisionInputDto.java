package nl.novi.techiteasy_spring.dto.input;
import jakarta.validation.constraints.*;
import java.util.Date;

public class TelevisionInputDto {
    public String type;
    @NotBlank
    public String name;
    @NotBlank
    public String brand;
    @NotBlank
    @Positive
    public double price;
    public double availableSize;
    public Double refreshRate;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean hdr;
    public Boolean bluetooth;
    public Boolean ambiLight;
    public Integer originalStock;
    public Integer sold;
    public Date dateSold;
    public nl.novi.techiteasy_spring.models.Television.screenType screenType;
}
