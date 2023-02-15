package com.CoLiving.Controller;

import com.CoLiving.Model.Filter;
import com.CoLiving.Model.Property;
import com.CoLiving.Service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/get/all/properties")
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/get/property/{id}")
    public Optional<Property> getPropertyById(@PathVariable UUID id) {
        return Optional.ofNullable(propertyService.getPropertyById(id));
    }

    @PostMapping("/add/property")
    public Property addProperty(@RequestBody Property property) {
        return propertyService.addProperty(property);
    }

    @PutMapping("/update/property")
    public Property updateProperty(@RequestBody Property property){
        return propertyService.updateProperty(property);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProperty(@PathVariable UUID id){
        propertyService.deleteProperty(id);
    }

    @GetMapping("/get/property/name")
    public List<Property> findPropertyByRegexpName(@RequestParam String propertyName){
        return propertyService.findPropertyByRegexpName(propertyName);
    }

    @GetMapping("/get/property/city/name")
    public List<Property> findPropertyByCity(@RequestParam String cityName){
        return propertyService.findPropertyByCity(cityName);
    }

    @GetMapping("/filter")
    public List<Property> filterProperty(@RequestBody Filter filter){
        return propertyService.filterProperty((filter));
    }
    @GetMapping("/listing/pagination")
    public List<Property> listingWithPagination(@RequestParam int pageNo, @RequestParam int size){
        return propertyService.listingWithPagination(pageNo , size);
    }
}
