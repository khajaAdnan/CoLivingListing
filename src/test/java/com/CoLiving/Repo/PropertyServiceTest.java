package com.CoLiving.Repo;

import com.CoLiving.Model.Property;
import com.CoLiving.Repository.PropertyRepo;
import com.CoLiving.Service.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

    @Mock
    private PropertyRepo propertyRepo;

    private PropertyService propertyService;

    @BeforeEach
    void setUp(){
        this.propertyService = new PropertyService(this.propertyRepo);
    }

    @Test
    void getAllProperties() {
        propertyService.getAllProperties();
        verify(propertyRepo).findAll();
    }

    @Test
    void filterProperty(){

        List<Property> propertyList = propertyRepo.findPropertyByCity("Hyderabad");
        for (Property property : propertyList){
            String name = property.getAddress().getCity();
            assertThat(name).isEqualTo("Hyderabad");
        }
    }

    @Test
    void getPropertyById(){
        propertyService.getPropertyById(UUID.fromString("f7ed22d9-324b-42be-a7a6-a5337cf4ec11"));
        assertThat(propertyRepo.findById(UUID.fromString("f7ed22d9-324b-42be-a7a6-a5337cf4ec11")));
    }

    @Test
    void addProperty(){
        Property property = new Property();
        property.setPropertyName("sergwrtg");
        when(propertyRepo.save(property)).thenReturn(property);
        assertEquals(property , propertyService.addProperty(property));
    }

    @Test
       void deleteProperty() {
        Property property = new Property();
        property.setPropertyName("sgerg");
        propertyService.deleteProperty(property.getPropertyId());
        verify(propertyRepo , times(1)).deleteById(property.getPropertyId());
    }

    @Test
       void listingWithPagination(){
        List<Property> propertyList = (List<Property>) propertyRepo.findAll();
        for(Property property : propertyList){
            assertThat(propertyList).isNotNull();
        }
    }
}