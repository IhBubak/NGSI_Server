package com.NGSI.Server.NGSIServer.repository;

import com.NGSI.Server.NGSIServer.model.Parking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParkingRepository extends MongoRepository<Parking, String> {
}
