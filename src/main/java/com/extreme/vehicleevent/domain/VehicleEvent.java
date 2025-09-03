package com.extreme.vehicleevent.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleEvent {
    private int eventType;
    private String vehicleId;
    private int eventCode;
    private String systemDateStr;
    private double speed;
    private String latitudeRaw;
    private String longitudeRaw;
    private Double odometer;
    private String ipAddress;
    private int port;
    private Integer geofenceIndex;
    private Boolean vehicleOn;
    private String signalStatus;
    private LocalDateTime realtimeDate;
    private String address;
    private String city;
    private String department;
    private LocalDateTime keepAliveDate;

    private Double processedLatitude;
    private Double processedLongitude;
    private LocalDateTime processedDate;
}
