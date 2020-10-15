package by.resliv.tourist_bot.service.modelDto;

import by.resliv.tourist_bot.model.City;
import by.resliv.tourist_bot.model.CityInfo;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CityInfoAddDto {

    private String nameCity;

    private String infoCity;

    public City fromDtoToCity(CityInfoAddDto cityInfoAddDto) {
        return new City().setName(cityInfoAddDto.getNameCity().toLowerCase());
    }

    public CityInfo fromDtoToCityInfo(CityInfoAddDto cityInfoAddDto) {
        return new CityInfo().setValue(cityInfoAddDto.getInfoCity());
    }
}
