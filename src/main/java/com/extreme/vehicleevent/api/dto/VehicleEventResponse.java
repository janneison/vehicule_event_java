package com.extreme.vehicleevent.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleEventResponse {
    private String status;
    private String message;
}
