package com.NGSI.Server.NGSIServer.service;

import com.NGSI.Server.NGSIServer.model.Parking;
import com.NGSI.Server.NGSIServer.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingService {
    private final ParkingRepository repository;
    public String save(Parking parking){
        return repository.save(parking).getId();
    }
    public Parking findById(String id){
        return repository.findById(id).orElse(null);
    }
    public List<Parking> findAll(){
        return repository.findAll();
    }
//    public Parking updateById(Parking updatedParking){
//        String id = updatedParking.getId();
//        Parking existingParking = repository.findById(id).orElse(null);
//        if(existingParking!=null){
//            return null;
//        }
//        repository.deleteById(id);
//        return repository.save(updatedParking);
//    }
//    public void deleteById(String id){
//        repository.deleteById(id);
//    }
//    public void deleteAll(){
//        repository.deleteAll();
//    }
}
