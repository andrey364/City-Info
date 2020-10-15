package by.resliv.tourist_bot.service;

import by.resliv.tourist_bot.service.modelDto.CityDto;
import by.resliv.tourist_bot.service.modelDto.CityInfoAddDto;

import java.util.List;

public interface CityService {

    List<CityDto> getAllCity();

    Integer addCityAndInfo(CityInfoAddDto cityInfoAddDto);

    CityDto editCity(CityDto cityDto, Integer idCity);

    void removeCity(Integer idCity);

    CityDto getCity(Integer idCity);
}
