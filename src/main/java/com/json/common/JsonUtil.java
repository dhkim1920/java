package com.json.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.dto.Car;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtil {

    public static void writeValueCar(String path, Car car) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), car);
    }

    public static Car readValueCar(String path, Class clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return (Car) objectMapper.readValue(new File(path), clazz);
    }

}
