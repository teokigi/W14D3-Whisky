package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    List<Whisky> findByYear(Integer year);
    List<Whisky> findWhiskyByDistilleryId(Long id);
    List<Whisky> findWhiskyByDistilleryIdAndAge(Long id, int Age);
    List<Whisky> findWhiskyByDistilleryRegionIgnoreCase(String region);
}
