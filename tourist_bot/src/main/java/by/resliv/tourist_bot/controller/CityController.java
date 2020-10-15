package by.resliv.tourist_bot.controller;


import by.resliv.tourist_bot.service.CityService;
import by.resliv.tourist_bot.service.modelDto.CityDto;
import by.resliv.tourist_bot.service.modelDto.CityInfoAddDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping("/cities")
    public ResponseEntity<Void> addCityAndInfo(@RequestBody CityInfoAddDto cityInfoAddDto) {
        try {
            cityService.addCityAndInfo(cityInfoAddDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "This city has already been added earlier", e);
        }
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityDto>> getAllCity() {
        List<CityDto> cityDtoList = cityService.getAllCity();
        return cityDtoList.isEmpty()
            ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
            : ResponseEntity.status(HttpStatus.OK).body(cityDtoList);
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<CityDto> getCity(@PathVariable Integer id) {
        try {
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(cityService.getCity(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "City not found", e);
        }
    }

    @PutMapping("/cities/{id}")
    public ResponseEntity<CityDto> editCity(@RequestBody CityDto cityDto, @PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cityService.editCity(cityDto, id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "City not found", e);
        }
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<Void> removeCity(@PathVariable Integer id) {
        try {
            cityService.removeCity(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found", e);
        }
    }
}
