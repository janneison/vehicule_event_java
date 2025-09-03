package com.extreme.vehicleevent.api;

import com.extreme.vehicleevent.api.dto.VehicleEventRequest;
import com.extreme.vehicleevent.api.dto.VehicleEventResponse;
import com.extreme.vehicleevent.domain.VehicleEvent;
import com.extreme.vehicleevent.service.VehicleEventProcessorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class VehicleEventController {

    @Value("${api.key:changeme}")
    private String apiKey;

    private final VehicleEventProcessorService service;

    @PostMapping("/process-vehicle-event")
    public ResponseEntity<VehicleEventResponse> processVehicleEvent(
            @RequestBody VehicleEventRequest request,
            @RequestHeader(value = "X-API-Key", required = false) String headerKey) {
        if (headerKey == null || !headerKey.equals(apiKey)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        VehicleEvent event = VehicleEvent.builder()
                .eventType(request.getTipo())
                .vehicleId(request.getIdveh())
                .eventCode(request.getIdevento())
                .systemDateStr(request.getFechasys())
                .speed(request.getSpeed())
                .latitudeRaw(request.getLat())
                .longitudeRaw(request.getLon())
                .odometer(request.getOdometer())
                .ipAddress(request.getIp())
                .port(request.getPort())
                .geofenceIndex(request.getIndexgeocerca())
                .vehicleOn(request.getVehicleOn())
                .signalStatus(request.getSignal())
                .realtimeDate(request.getRealtime())
                .address(request.getAddress())
                .city(request.getCity())
                .department(request.getDepartment())
                .keepAliveDate(request.getFechakeep())
                .build();

        String message = service.processEvent(event);
        return ResponseEntity.ok(new VehicleEventResponse("OK", message));
    }
}
