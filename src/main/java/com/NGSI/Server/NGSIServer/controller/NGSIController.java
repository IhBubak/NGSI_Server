package com.NGSI.Server.NGSIServer.controller;

import com.NGSI.Server.NGSIServer.model.Parking;
import com.NGSI.Server.NGSIServer.model.Vehicle;
import com.NGSI.Server.NGSIServer.service.ParkingService;
import com.NGSI.Server.NGSIServer.service.VehicleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@SecurityRequirement(name = "bearerAuth")
public class NGSIController {
    private final ParkingService parkingService;
    private final VehicleService vehicleService;
    @PostMapping("/Parking")
    public ResponseEntity<String> save(@RequestBody Parking parking){
        return ResponseEntity.ok(parkingService.save(parking));
    }
    @PostMapping("/Vehicle")
    public ResponseEntity<String> save(@RequestBody Vehicle vehicle){
        return ResponseEntity.ok(vehicleService.save(vehicle));
    }
    @GetMapping("/Parkings")
    public ResponseEntity<List<Parking>> findAllParkings(){
        return ResponseEntity.ok(parkingService.findAll());
    }
    @GetMapping("/Vehicles")
    public ResponseEntity<List<Vehicle>> findAllVehicles(){
        return ResponseEntity.ok(vehicleService.findAll());
    }
    @GetMapping("/Parking/{parking-id}")
    public ResponseEntity<Parking> findParking(@PathVariable("parking-id") String parkingId){
        return ResponseEntity.ok(parkingService.findById(parkingId));
    }
    @GetMapping("/Vehicle/{vehicle-id}")
    public ResponseEntity<Vehicle> findVehicle(@PathVariable("vehicle-id") String vehicleId){
        return ResponseEntity.ok(vehicleService.findById(vehicleId));
    }
//    @DeleteMapping("/Parking/{parking-id}")
//    public ResponseEntity<Void> deleteParking(@PathVariable("parking-id") String parkingId){
//        parkingService.deleteById(parkingId);
//        return ResponseEntity.accepted().build();
//    }
//    @DeleteMapping("/Vehicle/{vehicle-id}")
//    public ResponseEntity<Void> deleteVehicle(@PathVariable("vehicle-id") String vehicleId){
//        vehicleService.deleteById(vehicleId);
//        return ResponseEntity.accepted().build();
//    }
}
