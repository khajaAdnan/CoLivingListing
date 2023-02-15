package com.CoLiving.Repo;

import com.CoLiving.Model.Property;
import com.CoLiving.Repository.PropertyRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PropertyRepoTest {

    @Autowired
    private PropertyRepo propertyRepo;

    @Test
    void findPropertyByRegexpName() {

        List<Property> propertyList = propertyRepo.findPropertyByRegexpName("tri Coliving");
        for (Property property : propertyList){
            String name = property.getPropertyName();
            assertThat(name).isEqualTo("tri Coliving");
        }
    }

    @Test
    void findPropertyByCity() {
        List<Property> propertyList = propertyRepo.findPropertyByCity("Hyderabad");
        for (Property property : propertyList){
            String name = property.getAddress().getCity();
            assertThat(name).isEqualTo("Hyderabad");
        }
    }
}