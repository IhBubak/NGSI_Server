package com.NGSI.Server.NGSIServer.service;

import com.NGSI.Server.NGSIServer.model.Parking;
import com.NGSI.Server.NGSIServer.model.Vehicle;
import com.NGSI.Server.NGSIServer.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository repository;
    public String save(Vehicle vehicle){
        return repository.save(vehicle).getId();
    }
    public Vehicle findById(String id){
        return repository.findById(id).orElse(null);
    }
    public List<Vehicle> findAll(){
        return repository.findAll();
    }
//    public Vehicle updateById(Vehicle updatedVehicle){
//        String id = updatedVehicle.getId();
//        Vehicle existingVehicle = repository.findById(id).orElse(null);
//        if(existingVehicle!=null){
//            return null;
//        }
//        repository.deleteById(id);
//        return repository.save(updatedVehicle);
//    }
//    public void deleteById(String id){
//        repository.deleteById(id);
//    }
//    public void deleteAll(){
//        repository.deleteAll();
//    }
}
