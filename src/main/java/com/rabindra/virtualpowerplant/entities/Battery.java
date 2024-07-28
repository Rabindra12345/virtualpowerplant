package com.rabindra.virtualpowerplant.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

//hibernate takes javax persistence
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity(name = "battery")
public class Battery {

    @Id
    @Column(name = "battery_id")
    private String id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "postcode")
    private Integer postcode;

    @Column(name = "watt_capacity")
    private double wattCapacity;

    public Battery(String id, String brandName, Integer postcode, double wattCapacity) {
        this.id = id;

        this.brandName = brandName;
        this.postcode = postcode;
        this.wattCapacity = wattCapacity;
    }
}
