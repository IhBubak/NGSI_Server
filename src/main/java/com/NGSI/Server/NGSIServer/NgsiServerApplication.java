package com.NGSI.Server.NGSIServer;

import com.NGSI.Server.NGSIServer.model.Parking;
import com.NGSI.Server.NGSIServer.model.Vehicle;
import com.NGSI.Server.NGSIServer.model.subModelsParking.AvailableSpotNumber;
import com.NGSI.Server.NGSIServer.model.subModelsParking.Geometry;
import com.NGSI.Server.NGSIServer.model.subModelsParking.Properties;
import com.NGSI.Server.NGSIServer.model.subModelsParking.ProvidedBy;
import com.NGSI.Server.NGSIServer.service.NGSIClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class NgsiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgsiServerApplication.class, args);

		NGSIClient ngsiClient = new NGSIClient(webClientBuilder());

//		Parking parking = new Parking(/**/);
//		String parkingId = ngsiClient.saveParking(parking);
//		System.out.println("Saved Parking with ID: " + parkingId);
//		Vehicle vehicle = new Vehicle(/**/);
//		String vehicleId = ngsiClient.saveVehicle(vehicle);
//		System.out.println("Saved Vehicle with ID: " + vehicleId);
//		System.out.println("All Parkings: " + parkings);
//		System.out.println("All Vehicles: " + vehicles);
//		String specificParkingId = /**/;
//		Parking specificParking = ngsiClient.findParking(specificParkingId);
//		System.out.println("Found Parking: " + specificParking);
//		String specificVehicleId = /**/;
//		Vehicle specificVehicle = ngsiClient.findVehicle(specificVehicleId);
//		System.out.println("Found Vehicle: " + specificVehicle);
		System.out.println("-------------------------------");
		ngsiClient.findAllParkings();
		System.out.println("-------------------------------");
		ngsiClient.findAllVehicles();
		System.out.println("-------------------------------");
		ngsiClient.findVehicle("urn:ngsi-ld:Vehicle:X7890");


		System.out.println("-------------------------------");
		System.out.println("-------------------------------");
		Parking parkingSpot1 = new Parking();
		parkingSpot1.setId("urn:ngsi-ld:OffStreetParking:ShoppingMall1");
		parkingSpot1.setType("Feature");
		Geometry geometry = new Geometry();
		geometry.setType("Point");
		List<Double> coordinates = Arrays.asList(-8.55, 41.2);
		geometry.setCoordinates(coordinates);
		parkingSpot1.setGeometry(geometry);
		Properties properties = new Properties();
		properties.setType("OffStreetParking");
		properties.setName("Shopping Mall One");
		AvailableSpotNumber availableSpotNumber = new AvailableSpotNumber();
		availableSpotNumber.setValue(200.0);
		availableSpotNumber.setObservedAt("2023-10-31T13:30:00Z");
		availableSpotNumber.setReliability(0.9);
		ProvidedBy providedBy = new ProvidedBy();
		providedBy.setObject("urn:ngsi-ld:Camera:Cam5");
		availableSpotNumber.setProvidedBy(providedBy);
		properties.setAvailableSpotNumber(availableSpotNumber);
		Geometry location = new Geometry();
		location.setType("Point");
		List<Double> locationCoordinates = Arrays.asList(-8.55, 41.2);
		location.setCoordinates(locationCoordinates);
		properties.setLocation(location);
		properties.setTotalSpotNumber(300.0);
		properties.setContext(Arrays.asList(
				"http://example.org/ngsi-ld/latest/parking.jsonld",
				"https://uri.etsi.org/ngsi-ld/v1/ngsi-ld-core-context-v1.7.jsonld"
		));
		parkingSpot1.setProperties(properties);
		ngsiClient.createParking(parkingSpot1);
	}
	public static WebClient.Builder webClientBuilder() {
		return WebClient.builder().baseUrl("http://127.0.0.1:8080/api/v1");
	}
}
