package com.rabindra.virtualpowerplant.controller;

import com.rabindra.virtualpowerplant.constant.ErrorCode;
//import com.rabindra.virtualpowerplant.dao.BatteryDaoImpl;
import com.rabindra.virtualpowerplant.dtos.ApiResponse;
import com.rabindra.virtualpowerplant.dtos.BatteryDto;
import com.rabindra.virtualpowerplant.entities.Battery;
import com.rabindra.virtualpowerplant.service.BatteryService;
import com.rabindra.virtualpowerplant.utils.Urls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BatteryController {

    @Autowired
    private BatteryService batteryService;

    @PostMapping(value= Urls.BATTERY_ADD,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<?>> addBatteries(@RequestBody List<Battery> batteries) {
        List<Battery> savedBatteries = batteryService.saveAllBatteries(batteries);
        return ResponseEntity.ok(ApiResponse.forSuccess(ErrorCode.OK.getCode(), savedBatteries));
    }

    @GetMapping(value= Urls.BATTERY_ADD,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<?>> getBatteriesInPostcodeRange(@RequestParam(required = true) Integer startPostcode,
                                                                     @RequestParam(required = true) Integer endPostcode) {
        System.out.println("_____________________________________________Received startPostcode: " + startPostcode + ", endPostcode: " + endPostcode);
        BatteryDto batteryDetails = batteryService.getBatteriesInPostcodeRange(startPostcode, endPostcode);
        return ResponseEntity.ok(ApiResponse.forSuccess(ErrorCode.OK.getCode(), batteryDetails));
    }
}
