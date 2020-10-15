package by.resliv.tourist_bot.service.impl;

import by.resliv.tourist_bot.model.City;
import by.resliv.tourist_bot.model.CityInfo;
import by.resliv.tourist_bot.repository.CityInfoRepository;
import by.resliv.tourist_bot.repository.CityRepository;
import by.resliv.tourist_bot.service.CityInfoService;
import by.resliv.tourist_bot.service.modelDto.CityInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class CityInfoServiceImpl implements CityInfoService {

    private final CityInfoRepository cityInfoRepository;
    private final CityRepository cityRepository;

    @Override
    @Transactional
    public CityInfoDto updateCityInfo(CityInfoDto cityInfoDto, Integer id) {
        CityInfo cityInfo = cityInfoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("CityInfo with id = \"%s\" was not found", id)));
        cityInfo.setValue(cityInfoDto.getValue());
        CityInfoDto newCityInfoDto = new CityInfoDto();
        return newCityInfoDto.toDto(cityInfo);
    }

    @Override
    @Transactional(readOnly = true)
    public String getCityInfo(String cityName) {
        Optional<City> city = cityRepository.findCityByName(cityName.toLowerCase());
        if (city.isPresent()) {
            return new CityInfoDto().toDto(city.get().getCityInfo()).getValue();
        }
        return "Информации о данных в базе нет. Попробуйте ввести город ещё раз.";
    }
}
