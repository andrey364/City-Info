package by.resliv.tourist_bot.service.modelDto;

import by.resliv.tourist_bot.model.CityInfo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class CityInfoDto {

    private String value;

    public CityInfoDto toDto(CityInfo cityInfo) {
        return new CityInfoDto()
            .setValue(cityInfo.getValue());
    }
}
