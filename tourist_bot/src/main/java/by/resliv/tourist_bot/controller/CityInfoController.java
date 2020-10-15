package by.resliv.tourist_bot.controller;

import by.resliv.tourist_bot.service.CityInfoService;
import by.resliv.tourist_bot.service.modelDto.CityInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class CityInfoController {

    private final CityInfoService cityInfoService;

    @PutMapping("/city-info/{id}")
    public ResponseEntity<CityInfoDto> updateCityInfo(@RequestBody CityInfoDto cityInfoDto, @PathVariable Integer id) {
        try {
        return ResponseEntity.status(HttpStatus.OK).body(cityInfoService.updateCityInfo(cityInfoDto, id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "City not found", e);
        }
    }
}
