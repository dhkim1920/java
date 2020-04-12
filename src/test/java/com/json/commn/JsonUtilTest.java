package com.json.commn;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.common.JsonUtil;
import com.json.dto.Car;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class JsonUtilTest {

    private String testPath = "src/test/resources/test.json";

    @Test
    public void writeValueTest() throws IOException {
        Car car = new Car("red", "small");
        JsonUtil.writeValueCar(testPath, car);
    }

    @Test
    public void readValueTest() throws IOException {
        Car car = JsonUtil.readValueCar(testPath, Car.class);
        System.out.println(car.getColor());
        System.out.println(car.getType());
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
}
