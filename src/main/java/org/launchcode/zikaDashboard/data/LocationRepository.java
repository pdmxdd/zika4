package org.launchcode.zikaDashboard.data;

import org.launchcode.zikaDashboard.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByCountryNameAndStateName(String country, String state);
}
