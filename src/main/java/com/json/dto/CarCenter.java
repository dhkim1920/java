package com.json.dto;

import java.time.LocalDate;
import java.util.List;

public class CarCenter {

    private LocalDate localDate;
    private List<Car> cars;

    public CarCenter() {
    }

    public CarCenter(LocalDate localDate, List<Car> cars) {
        this.localDate = localDate;
        this.cars = cars;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
