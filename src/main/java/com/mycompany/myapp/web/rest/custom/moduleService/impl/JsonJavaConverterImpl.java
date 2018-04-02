package com.mycompany.myapp.web.rest.custom.moduleService.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.myapp.web.rest.custom.moduleService.JsonJavaConverter;

import org.springframework.stereotype.Service;

@Service
public class JsonJavaConverterImpl implements JsonJavaConverter {

    @Override
    public String convertToJson(Object entityClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonObject = "";
        try {
            jsonObject = objectMapper.writeValueAsString(entityClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
