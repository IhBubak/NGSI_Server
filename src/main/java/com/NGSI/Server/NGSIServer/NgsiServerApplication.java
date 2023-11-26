package com.NGSI.Server.NGSIServer;

import com.NGSI.Server.NGSIServer.model.Parking;
import com.NGSI.Server.NGSIServer.model.Vehicle;
import com.NGSI.Server.NGSIServer.service.NGSIClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.codec.xml.Jaxb2XmlDecoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@SpringBootApplication
public class NgsiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgsiServerApplication.class, args);

		NGSIClient ngsiClient = new NGSIClient(webClientBuilder());

//		Parking parking = new Parking(/**/);
//		String parkingId = ngsiClient.saveParking(parking);
//		System.out.println("Saved Parking with ID: " + parkingId);
//
//		Vehicle vehicle = new Vehicle(/**/);
//		String vehicleId = ngsiClient.saveVehicle(vehicle);
//		System.out.println("Saved Vehicle with ID: " + vehicleId);

		System.out.println("-------------------------------");
		ngsiClient.findAllParkings();
		//System.out.println("All Parkings: " + parkings);
		System.out.println("-------------------------------");
		ngsiClient.findAllVehicles();
		System.out.println("-------------------------------");
		ngsiClient.findVehicle("urn:ngsi-ld:Vehicle:X7890");
		//System.out.println("All Vehicles: " + vehicles);

//		String specificParkingId = /**/;
//		Parking specificParking = ngsiClient.findParking(specificParkingId);
//		System.out.println("Found Parking: " + specificParking);
//
//		String specificVehicleId = /**/;
//		Vehicle specificVehicle = ngsiClient.findVehicle(specificVehicleId);
//		System.out.println("Found Vehicle: " + specificVehicle);
	}
	public static WebClient.Builder webClientBuilder() {
		return WebClient.builder().baseUrl("http://127.0.0.1:8080/api/v1");
	}
}
