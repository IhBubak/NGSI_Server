package com.NGSI.Server.NGSIServer.service;
import com.NGSI.Server.NGSIServer.dto.XmlResponse;
import com.NGSI.Server.NGSIServer.model.Parking;
import com.NGSI.Server.NGSIServer.model.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;

@Service
public class NGSIClient {

    private final WebClient webClient;

    public NGSIClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }
    /**
     *
     * die Lösung mit JSON
     */
//    public String saveParking(Parking parking) {
//        ResponseEntity<String> response = webClient.post()
//                .uri("/Parking")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(parking)
//                .retrieve()
//                .toEntity(String.class)
//                .block();
//
//        return response.getBody();
//    }
//
//    public String saveVehicle(Vehicle vehicle) {
//        ResponseEntity<String> response = webClient.post()
//                .uri("/Vehicle")
//                .contentType(MediaType.APPLICATION_JSON)
//                .bodyValue(vehicle)
//                .retrieve()
//                .toEntity(String.class)
//                .block();
//
//        return response.getBody();
//    }
//    public List<Parking> findAllParkings() {
//        return webClient.get()
//                .uri("/Parkings")
//                .retrieve()
//                .bodyToFlux(Parking.class)
//                .collectList()
//                .block();
//    }
//
//    public List<Vehicle> findAllVehicles() {
//        return webClient.get()
//                .uri("/Vehicles")
//                .retrieve()
//                .bodyToFlux(Vehicle.class)
//                .collectList()
//                .block();
//    }
//
//    public Parking findParking(String parkingId) {
//        return webClient.get()
//                .uri("/Parking/{parking-id}", parkingId)
//                .retrieve()
//                .bodyToMono(Parking.class)
//                .block();
//    }
//
//    public Vehicle findVehicle(String vehicleId) {
//        return webClient.get()
//                .uri("/Vehicle/{vehicle-id}", vehicleId)
//                .retrieve()
//                .bodyToMono(Vehicle.class)
//                .block();
//    }
    /**
     * die Lösung mit XML
     */
    public String createParking(Parking parking) {
        return webClient.post()
                .uri("/Parking")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(parking))
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(response ->{
                    String xmlResponse = convertJsonToXml(response);
                    System.out.println("Create Parking Response (XML): " + xmlResponse);
                })
                .block();
    }
    private String convertJsonToXml(String jsonResponse) {
        try {
            XmlResponse parkingXmlResponse = new XmlResponse(jsonResponse);
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writeValueAsString(parkingXmlResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String createVehicle(Vehicle vehicle) {
        return webClient.post()
                .uri("/Vehicle")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(vehicle))
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(response ->{
                    String xmlResponse = convertJsonToXml(response);
                    System.out.println("Create Parking Response (XML): " + xmlResponse);
                })
                .block();
    }
    public List<String> findAllParkings() {
        return webClient.get()
                .uri("/Parkings")
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToFlux(String.class)
                .doOnNext(xmlString -> System.out.println("XML Response: " + xmlString))
                .collectList()
                .block();
    }

    public List<String> findAllVehicles() {
        return webClient.get()
                .uri("/Vehicles")
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToFlux(String.class)
                .doOnNext(xmlString -> System.out.println("XML Response: " + xmlString))
                .collectList()
                .block();
    }

    public String findParking(String parkingId) {
        return webClient.get()
                .uri("/Parking/{parking-id}", parkingId)
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(xmlString -> System.out.println("XML Response: " + xmlString))
                .block();
    }

    public String findVehicle(String vehicleId) {
        return webClient.get()
                .uri("/Vehicle/{vehicle-id}", vehicleId)
                .accept(MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(xmlString -> System.out.println("XML Response: " + xmlString))
                .block();
    }
}

