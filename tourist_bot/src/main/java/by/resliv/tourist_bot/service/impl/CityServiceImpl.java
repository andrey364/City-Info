package by.resliv.tourist_bot.service.impl;

import by.resliv.tourist_bot.model.City;
import by.resliv.tourist_bot.model.CityInfo;
import by.resliv.tourist_bot.repository.CityInfoRepository;
import by.resliv.tourist_bot.repository.CityRepository;
import by.resliv.tourist_bot.service.CityService;
import by.resliv.tourist_bot.service.modelDto.CityDto;
import by.resliv.tourist_bot.service.modelDto.CityInfoAddDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityInfoRepository cityInfoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CityDto> getAllCity() {
        List<City> cityList = cityRepository.findAll();
        List<CityDto> cityDtoList = new ArrayList<>();
        for (City city : cityList) {
            cityDtoList.add(new CityDto().toDto(city));
        }
        return cityDtoList;
    }

    @Override
    @Transactional
    public Integer addCityAndInfo(CityInfoAddDto cityInfoAddDto) {

        cityRepository.findCityByName(cityInfoAddDto.getNameCity()).orElseThrow(() -> new EntityExistsException("This city has already been added earlier"));

        City city = cityInfoAddDto.fromDtoToCity(cityInfoAddDto);
        city = cityRepository.save(city);
        CityInfo cityInfo = cityInfoAddDto.fromDtoToCityInfo(cityInfoAddDto);
        cityInfo.setIdCity(city.getId());
        cityInfoRepository.save(cityInfo);
        return city.getId();
    }

    @Override
    @Transactional
    public CityDto editCity(CityDto cityDto, Integer id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("City with id = \"%s\" was not found", id)));
        city.setName(cityDto.getName());
        CityDto newCityDto = new CityDto();
        return newCityDto.toDto(city);
    }

    @Override
    @Transactional
    public void removeCity(Integer id) {
        cityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("City with id = \"%s\" can't be deleted, because not found", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public CityDto getCity(Integer id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new EntityExistsException(String.format("City with id \"%s\" was not found", id)));
        return new CityDto().toDto(city);
    }
}