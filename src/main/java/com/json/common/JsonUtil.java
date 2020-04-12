package com.json.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.dto.Car;
import com.json.dto.CarCenter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil {

    public static void writeValueCar(String path, Car car) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), car);
    }

    public static Car readValueCar(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), Car.class);
    }

    public static void writeValueCarCenter(String path, CarCenter carCenter) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), carCenter);
    }

    public static CarCenter readValueCarCenter(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), new TypeReference<CarCenter>(){});
    }
}
