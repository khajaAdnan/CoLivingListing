package com.CoLiving.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class Rooms {
    private int roomNumber;
    private int numberOfBeds;
    public enum TypeOfRoom{
        acRooms , NonAc , Sharing , Single
    }
    private TypeOfRoom typeOfRoom;

    private Boolean roomStatus;
    public  List<Bed> bedData;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public TypeOfRoom getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(TypeOfRoom typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public Boolean getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public List<Bed> getBedData() {
        return bedData;
    }

    public void setBedData(List<Bed> bedData) {
        this.bedData = bedData;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                ", roomNumber=" + roomNumber +
                ", numberOfBeds=" + numberOfBeds +
                ", typeOfRoom=" + typeOfRoom +
                ", roomStatus=" + roomStatus +
                ", bedData=" + bedData +
                '}';
    }
}
