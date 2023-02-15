package com.CoLiving.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class Floor {

    private List<Rooms> roomData;
    private int numberOfRooms;
    private int floorNumber;

    public List<Rooms> getRoomData() {
        return roomData;
    }

    public void setRoomData(List<Rooms> roomData) {
        this.roomData = roomData;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Floor{" +
                ", roomData=" + roomData +
                ", numberOfRooms=" + numberOfRooms +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
