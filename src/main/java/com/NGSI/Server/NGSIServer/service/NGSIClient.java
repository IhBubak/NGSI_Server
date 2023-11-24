package com.NGSI.Server.NGSIServer.service;
import com.NGSI.Server.NGSIServer.model.Parking;
import com.NGSI.Server.NGSIServer.model.Vehicle;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class NGSIClient {

    private final WebClient webClient;

    public NGSIClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String saveParking(Parking parking) {
        ResponseEntity<String> response = webClient.post()
                .uri("/Parking")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(parking)
                .retrieve()
                .toEntity(String.class)
                .block();

        return response.getBody();
    }

    public String saveVehicle(Vehicle vehicle) {
        ResponseEntity<String> response = webClient.post()
                .uri("/Vehicle")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(vehicle)
                .retrieve()
                .toEntity(String.class)
                .block();

        return response.getBody();
    }

    public List<Parking> findAllParkings() {
        return webClient.get()
                .uri("/Parkings")
                .retrieve()
                .bodyToFlux(Parking.class)
                .collectList()
                .block();
    }

    public List<Vehicle> findAllVehicles() {
        return webClient.get()
                .uri("/Vehicles")
                .retrieve()
                .bodyToFlux(Vehicle.class)
                .collectList()
                .block();
    }

    public Parking findParking(String parkingId) {
        return webClient.get()
                .uri("/Parking/{parking-id}", parkingId)
                .retrieve()
                .bodyToMono(Parking.class)
                .block();
    }

    public Vehicle findVehicle(String vehicleId) {
        return webClient.get()
                .uri("/Vehicle/{vehicle-id}", vehicleId)
                .retrieve()
                .bodyToMono(Vehicle.class)
                .block();
    }
}

