package com.extreme.vehicleevent.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class VehicleEventRequest {
    @JsonProperty("tipo")
    private int tipo;

    @JsonProperty("idveh")
    private String idveh;

    @JsonProperty("idevento_")
    private int idevento;

    @JsonProperty("fechasys_")
    private String fechasys;

    @JsonProperty("speed")
    private double speed;

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lon")
    private String lon;

    @JsonProperty("odometer")
    private Double odometer;

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("port")
    private int port;

    @JsonProperty("indexgeocerca")
    private Integer indexgeocerca;

    @JsonProperty("vehicleon_")
    private Boolean vehicleOn;

    @JsonProperty("signal_")
    private String signal;

    @JsonProperty("realtime_")
    private LocalDateTime realtime;

    @JsonProperty("address_")
    private String address;

    @JsonProperty("city_")
    private String city;

    @JsonProperty("department_")
    private String department;

    @JsonProperty("fechakeep")
    private LocalDateTime fechakeep;
}
