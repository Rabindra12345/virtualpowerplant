package com.rabindra.virtualpowerplant.service;

import com.rabindra.virtualpowerplant.constant.ErrorCode;
import com.rabindra.virtualpowerplant.dtos.BatteryDto;
import com.rabindra.virtualpowerplant.entities.Battery;
import com.rabindra.virtualpowerplant.exception.NotFoundException;
import com.rabindra.virtualpowerplant.repositories.BatteryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryService {

    @Autowired
    private BatteryRepository batteryRepository;

    @Transactional
    public List<Battery> saveAllBatteries(List<Battery> battery) {
        if(battery.isEmpty()){
            throw new NotFoundException(ErrorCode.NOT_FOUND.getCode(), ErrorCode.NOT_FOUND.name(),
                    ErrorCode.NOT_FOUND.getMessage());
        }
        return batteryRepository.saveAll(battery);
    }

    @Transactional
    public BatteryDto getBatteriesInPostcodeRange(Integer startCode, Integer endCode) {
         List<Battery> batteriesFromDb = batteryRepository.findAll();
         System.out.println("______________ logging batteries from Db_"+batteriesFromDb);
         if(batteriesFromDb.isEmpty()){
             throw new NotFoundException(ErrorCode.NOT_FOUND.getCode(), ErrorCode.NOT_FOUND.name(),
                     String.format(ErrorCode.NOT_FOUND.getMessage(), "bad postcode range"));
         }
         List<Battery> batteryWithInPostalRange = batteriesFromDb.stream()
                 .filter(battery-> battery.getPostcode()>=startCode && battery.getPostcode()<=endCode)
                 .collect(Collectors.toList());

        List<String> batteryNames = batteryWithInPostalRange.stream()
                .map(Battery::getBrandName)
                .sorted()
                .collect(Collectors.toList());

        double totalWattCapacity = batteryWithInPostalRange.stream()
                .mapToDouble(Battery::getWattCapacity)
                .sum();

        double averageWattCapacity = batteryWithInPostalRange.stream()
                .mapToDouble(Battery::getWattCapacity)
                .average()
                .orElse(0.0);

        BatteryDto response = new BatteryDto();
        response.setBatteryNames(batteryNames);
        response.setTotalWattCapacity(totalWattCapacity);
        response.setAverageWattCapacity(averageWattCapacity);
        return response;
    }

}
