package com.json.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;
import java.util.List;

public class CarCenter {

    private String localDate;
    private List<Car> cars;

    public CarCenter() {
    }

    public CarCenter(String localDate, List<Car> cars) {
        this.localDate = localDate;
        this.cars = cars;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarCenter{" +
                "localDate='" + localDate + '\'' +
                ", cars=" + cars +
                '}';
    }
}
