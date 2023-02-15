package com.CoLiving.Repository;

import com.CoLiving.Model.Property;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PropertyRepo extends MongoRepository<Property , UUID> {

    @Query("{ 'PropertyName' : { $regex: '(?i)?0' } }")
    List<Property> findPropertyByRegexpName(String propertyName);


    @Query("{ 'cityName' : { $regex: '(?i)?0' } }")
    List<Property> findPropertyByCity(String cityName);
}
