package com.rabindra.virtualpowerplant.service;


import com.rabindra.virtualpowerplant.dtos.BatteryDto;
import com.rabindra.virtualpowerplant.entities.Battery;
import com.rabindra.virtualpowerplant.exception.NotFoundException;
import com.rabindra.virtualpowerplant.repositories.BatteryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BatteryServiceTests {

    @InjectMocks
    private BatteryService batteryService;

    @Mock
    BatteryRepository batteryDao;

    List<Battery> batteryList;

    @BeforeEach
    public void setUp() {
        batteryList = Arrays.asList(
                new Battery("B1",  "Brand A", 12345, 200),
                new Battery("B2", "Zen", 23456, 300),
                new Battery("B3", "Tiger", 34567,400)

        );
    }

    @Test
    @DisplayName("POSTAL CODE WITHIN REANGE SUCCESS TEST CASE")
    public void testGetBatteriesByPostcodeInRange_success_scenerio() {
        when(batteryDao.findAll()).thenReturn(batteryList);
        BatteryDto battery = batteryService.getBatteriesInPostcodeRange(10000, 35000);
        assertNotNull(battery);
        System.out.println(battery);
        List<String > sortedNameWithTotalWattCapacity = Arrays.asList("Brand A","Tiger","Zen");
        assertEquals(sortedNameWithTotalWattCapacity, battery.getBatteryNames());
        double totalCapacity = 900.0;
        assertEquals(totalCapacity,battery.getTotalWattCapacity());
    }

//    @Test
//    @DisplayName("POSTAL CODE WITHIN REANGE FAILURE TEST CASE")
//    public void testGetBatteriesByPostcodeInRange_failure_scenerio() {
//        when(batteryDao.findAll()).thenReturn(batteryList);
//        BatteryDto battery = batteryService.getBatteriesInPostcodeRange(10000, 35000);
//        List<String > sortedNameWithTotalWattCapacity = Arrays.asList("Brand A","Tiger","Zen");
//        double totalCapacity = 9000.0;
////        assertEquals(totalCapacity/3, battery.getAverageWattCapacity());
//        assertEquals(totalCapacity, battery.getTotalWattCapacity());
//    }

//    @Test
//    @DisplayName("POSTAL CODE WITHIN REANGE BUT NOT FOUND TEST CASE_SUCCESS")
//    void testGetBatteriesInPostcodeRange_NoBatteriesFound() {
//        when(batteryDao.findAll()).thenReturn(Collections.emptyList());
//        BatteryDto result = batteryService.getBatteriesInPostcodeRange(1000, 2000);
//        assertNotNull(result);
//        assertTrue(result.getBatteryNames().isEmpty());
//        assertEquals(0.0, result.getTotalWattCapacity(), 0.0);
//        assertEquals(0.0, result.getAverageWattCapacity(), 0.0);
//    }
//
//    @Test
//    @DisplayName("POSTAL CODE WITHIN REANGE BUT NOT FOUND TEST CASE_SUCCESS")
//    void testGetBatteriesInPostcodeRange_InvalidPostcodeRange() {
//        when(batteryDao.findAll()).thenReturn(Collections.emptyList());
//        assertThrows(NotFoundException.class, () -> {
//            batteryService.getBatteriesInPostcodeRange(2000, 1000);
//        });
//    }

}
