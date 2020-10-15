package by.resliv.tourist_bot.service;

import by.resliv.tourist_bot.service.modelDto.CityInfoDto;

public interface CityInfoService {

    CityInfoDto updateCityInfo(CityInfoDto cityInfoDto, Integer id);

    String getCityInfo(String cityName);
}
