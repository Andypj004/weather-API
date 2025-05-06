package com.weather.weatherApi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class CacheService {

    @Autowired
    private Jedis jedis;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void saveToCache(String key, Object value, int ttl){
        try {
            String jsonValue = objectMapper.writeValueAsString(value);
            jedis.setex(key, ttl, jsonValue);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing object to JSON", e);
        }
    }

    public <T> T getFromCache(String key, Class<T> clazz){
        String jsonValue = jedis.get(key);
        if(jsonValue != null){
            try {
                return objectMapper.readValue(jsonValue, clazz);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Error deserializing JSON to object", e);
            }
        }
        return null;
    }
}
