package com.extreme.vehicleevent.service;

import com.extreme.vehicleevent.domain.VehicleEvent;
import org.springframework.stereotype.Service;

@Service
public class VehicleEventProcessorService {

    public String processEvent(VehicleEvent event) {
        event.setProcessedLatitude(parseCoord(event.getLatitudeRaw()));
        event.setProcessedLongitude(parseCoord(event.getLongitudeRaw()));
        if (event.getRealtimeDate() != null) {
            event.setProcessedDate(event.getRealtimeDate());
        } else {
            event.setProcessedDate(event.getKeepAliveDate());
        }
        return "Procesado evento de " + event.getVehicleId();
    }

    private Double parseCoord(String coord) {
        if (coord == null || coord.length() < 2) {
            return null;
        }
        try {
            char dir = coord.charAt(0);
            double value = Double.parseDouble(coord.substring(1));
            if (dir == 'N' || dir == 'E') {
                return value;
            } else {
                return -value;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
