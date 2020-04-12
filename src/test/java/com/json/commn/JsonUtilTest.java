package com.json.commn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.common.JsonUtil;
import com.json.dto.Car;
import com.json.dto.CarCenter;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JsonUtilTest {

    private String testPath = "src/test/resources/test.json";
    private String testPath2 = "src/test/resources/test2.json";

    @Test
    public void writeValueTest() throws IOException {
        Car car = new Car("red", "small");
        JsonUtil.writeValueCar(testPath, car);
    }

    @Test
    public void readValueTest() throws IOException {
        Car car = JsonUtil.readValueCar(testPath);
        System.out.println(car.getColor());
        System.out.println(car.getType());
    }

    @Test
    public void writeValueCarCenterTest() throws IOException {
        CarCenter carCenter = new CarCenter();
        carCenter.setLocalDate(LocalDate.now().toString());

        List<Car> cars = new ArrayList<>();
        Car kia = new Car("yellow", "k5");
        Car bmw = new Car("black", "320d");
        cars.add(kia);
        cars.add(bmw);
        carCenter.setCars(cars);

        JsonUtil.writeValueCarCenter(testPath2, carCenter);
    }

    @Test
    public void readValue2Test() throws IOException {
        CarCenter carCenter = JsonUtil.readValueCarCenter(testPath2);
        System.out.println(carCenter);
    }

    @Test
    public void arrayReadTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});

        listCar.forEach(car -> {
            System.out.println(String.format("Color: %s, Type: %s", car.getColor(), car.getType()));
        });
    }

    @Test
    public void arrayReadTest2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCarArray =
                "{\"localDate\": \"2020-04-12\", " +
                        " \"cars\": [{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]}";
        CarCenter carCenter = objectMapper.readValue(jsonCarArray, new TypeReference<CarCenter>(){});

        System.out.println(carCenter.getLocalDate());
        carCenter.getCars().forEach(c -> {
            System.out.println(String.format("color: %s, type: %s", c.getColor(), c.getType()));
        });

    }
}
