package by.resliv.tourist_bot.service.modelDto;

import by.resliv.tourist_bot.model.City;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
@JsonRootName("city")
public class CityDto {

    private Integer id;

    private String name;

    public CityDto toDto(City city) {
        return new CityDto()
            .setId(city.getId())
            .setName(city.getName());
    }
}
