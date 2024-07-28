package com.rabindra.virtualpowerplant.repositories;

import com.rabindra.virtualpowerplant.entities.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery,String> {

//    @Query("SELECT b FROM Battery b WHERE")
//    List<Battery> getBatteriesInPostcodeRange();
}
