package com.json.dto;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarCenterTest {

    @Test
    public void createTest() {
        Car kia = new Car("blue", "KIA");
        Car bmw = new Car("red", "BMW");
        List<Car> cars = new ArrayList<>();
        cars.add(kia);
        cars.add(bmw);

        CarCenter carCenter = new CarCenter(LocalDate.now(), cars);

        System.out.println("date : " + carCenter.getLocalDate());
        carCenter.getCars().forEach(c -> {
            System.out.println(String.format("Color: %s, Type: %s", c.getColor(), c.getType()));
        });
    }

}
