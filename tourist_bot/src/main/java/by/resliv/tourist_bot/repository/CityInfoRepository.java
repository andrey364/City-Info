package by.resliv.tourist_bot.repository;

import by.resliv.tourist_bot.model.CityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityInfoRepository extends JpaRepository<CityInfo, Integer> {

}

