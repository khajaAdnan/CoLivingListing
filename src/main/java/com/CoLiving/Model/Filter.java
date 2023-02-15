package com.CoLiving.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Filter {
    private String city;
    private Property typeOfProperty;
    private Boolean status;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Property getTypeOfProperty() {
        return typeOfProperty;
    }

    public void setTypeOfProperty(Property typeOfProperty) {
        this.typeOfProperty = typeOfProperty;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Filter{" +
                "city='" + city + '\'' +
                ", typeOfProperty=" + typeOfProperty +
                ", status=" + status +
                '}';
    }
}
