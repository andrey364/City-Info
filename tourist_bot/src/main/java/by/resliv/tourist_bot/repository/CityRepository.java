package by.resliv.tourist_bot.repository;

import by.resliv.tourist_bot.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    Optional<City> findCityByName(String cityName);
}