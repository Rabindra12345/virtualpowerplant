package com.rabindra.virtualpowerplant.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BatteryDto {

//    private String id;

    private List<String> batteryNames;

    private double totalWattCapacity;

    private double averageWattCapacity;
}
