package com.NGSI.Server.NGSIServer.repository;

import com.NGSI.Server.NGSIServer.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
