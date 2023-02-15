package com.CoLiving.Service;

import com.CoLiving.Model.Filter;
import com.CoLiving.Model.Property;
import com.CoLiving.Repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepo propertyRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    // Testing
    public PropertyService(PropertyRepo propertyRepo) {
        this.propertyRepo = propertyRepo;
    }

    public Property addProperty(Property property) {
        return  propertyRepo.save(property);

    }

    public List<Property> getAllProperties(){
        return propertyRepo.findAll();
    }

    public Property getPropertyById(UUID id){
        return propertyRepo.findById(id).orElse( null);
    }

    public void deleteProperty(UUID id) {
        propertyRepo.deleteById(id);
    }


    public Property updateProperty(Property property) {
        AtomicReference<Property> propertyAtomicReference = new AtomicReference<>();
        Optional<Property> propertyOptional = propertyRepo.findById(property.getPropertyId());
        propertyOptional.ifPresent(data -> {
            data.setPropertyName(property.getPropertyName());
            data.setPropertyId(property.getPropertyId());
            data.setAmenities(property.getAmenities());
            data.setFloorData(property.getFloorData());
            data.setTypeOfProperty((property.getTypeOfProperty()));
            data.setAddress((property.getAddress()));
            data.setCreationOfTime((property.getCreationOfTime()));
            data.setUpdationOfTime((property.getUpdationOfTime()));
            propertyAtomicReference.set(propertyRepo.save(data));
        });
        return propertyAtomicReference.get();
    }

    public List<Property> listingWithPagination(int page , int size){
        Pageable pageable = PageRequest.of(page,size);
        Query query = new Query();
        query.with(pageable);
        List<Property> properties = mongoTemplate.find(query, Property.class);
        return properties;
    }

    public List<Property> findPropertyByRegexpName(String propertyName){
        return propertyRepo.findPropertyByRegexpName(propertyName);
    }

    public List<Property> findPropertyByCity(String cityName){
        return propertyRepo.findPropertyByCity(cityName);
    }

    public List<Property> filterProperty(Filter filter){
        Query query = new Query();
        if(filter.getCity()!=null) {
            query.addCriteria(Criteria.where("address.city").is(filter.getCity()));
        }
        if(filter.getTypeOfProperty()!=null){
            query.addCriteria(Criteria.where("TypeOfProperty").is(filter.getTypeOfProperty()));
        }
        if(filter.getStatus()!=null) {
            query.addCriteria(Criteria.where("isStatus").is(filter.getStatus()));
        }
        List<Property> properties = mongoTemplate.find(query,Property.class);
        return properties;
    }
}