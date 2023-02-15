package com.CoLiving.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Bed {
    public enum BedType{
        SINGLE , DOUBLE , KING, QUEEN
    }
    private BedType bedType;
    private Boolean bedStatus;
    private int bedNumber;


    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public Boolean getBedStatus() {
        return bedStatus;
    }

    public void setBedStatus(Boolean bedStatus) {
        this.bedStatus = bedStatus;
    }

    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    @Override
    public String toString() {
        return "Bed{" +
                ", bedType=" + bedType +
                ", bedStatus=" + bedStatus +
                ", bedNumber=" + bedNumber +
                '}';
    }
}