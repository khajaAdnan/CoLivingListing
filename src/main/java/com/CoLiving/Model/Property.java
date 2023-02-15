package com.CoLiving.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Document
public class Property {
    @Id
    private UUID propertyId;
    private String propertyName;
    public String amenities;
    private int numberOfFloors;
    public List<Floor> floorData;
    private Address address;
    private Date creationOfTime;
    private Date updationOfTime;
    private Boolean propertyStatus;
    public enum TypeOfProperty{
        COLIVING , MEN , WOMEN
    }

    public Property(String propertyName) {
        this.propertyName = propertyName;
    }


    public Property(UUID propertyId, String propertyName, String amenities, int numberOfFloors, List<Floor> floorData, Address address, Date creationOfTime, Date updationOfTime, Boolean propertyStatus, TypeOfProperty typeOfProperty) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.amenities = amenities;
        this.numberOfFloors = numberOfFloors;
        this.floorData = floorData;
        this.address = address;
        this.creationOfTime = creationOfTime;
        this.updationOfTime = updationOfTime;
        this.propertyStatus = propertyStatus;
        this.typeOfProperty = typeOfProperty;
    }



    private TypeOfProperty typeOfProperty;

    public Property() {
        this.propertyId = UUID.randomUUID();
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public UUID getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(UUID propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public List<Floor> getFloorData() {
        return floorData;
    }

    public void setFloorData(List<Floor> floorData) {
        this.floorData = floorData;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getCreationOfTime() {
        return creationOfTime;
    }

    public void setCreationOfTime(Date creationOfTime) {
        this.creationOfTime = creationOfTime;
    }

    public Date getUpdationOfTime() {
        return updationOfTime;
    }

    public void setUpdationOfTime(Date updationOfTime) {
        this.updationOfTime = updationOfTime;
    }

    public Boolean getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(Boolean propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    public TypeOfProperty getTypeOfProperty() {
        return typeOfProperty;
    }

    public void setTypeOfProperty(TypeOfProperty typeOfProperty) {
        this.typeOfProperty = typeOfProperty;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", amenities='" + amenities + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", floorData=" + floorData +
                ", address=" + address +
                ", creationOfTime=" + creationOfTime +
                ", updationOfTime=" + updationOfTime +
                ", propertyStatus=" + propertyStatus +
                ", typeOfProperty=" + typeOfProperty +
                '}';
    }
}
