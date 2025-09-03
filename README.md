# vehicule_event_java

Microservicio para registrar eventos de vehículos implementado con Spring Boot.

El proyecto toma como referencia la arquitectura y dependencias del microservicio [passengercount](https://github.com/janneison/passengercount) para la gestión de eventos a través de Kafka y persistencia en PostgreSQL.

## Construcción

```
mvn package
```

## Ejecución

```
mvn spring-boot:run
```

## Endpoint

El servicio expone un endpoint `POST /process-vehicle-event` que recibe un evento en el formato utilizado por `VehicleEventMS`. Se requiere la cabecera `X-API-Key` configurada mediante la propiedad `api.key`.

Ejemplo de petición:

```bash
curl -X POST http://localhost:8080/process-vehicle-event \
  -H "Content-Type: application/json" \
  -H "X-API-Key: changeme" \
  -d '{
    "tipo": 0,
    "idveh": "ABC123",
    "idevento_": 1,
    "fechasys_": "2024-05-01",
    "speed": 45.0,
    "lat": "N10.12345",
    "lon": "W074.98765",
    "ip": "127.0.0.1",
    "port": 5050,
    "fechakeep": "2024-05-01T12:00:00"
  }'
```
