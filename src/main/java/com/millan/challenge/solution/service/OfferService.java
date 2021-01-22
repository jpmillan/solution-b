package com.millan.challenge.solution.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.millan.challenge.solution.model.Offer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
@Slf4j
public class OfferService {

    @Cacheable(cacheNames = "offers")
    public List<Offer> getOffers() {
        List<Offer> offers = null;

        try {

            offers = loadOffers();
        } catch (IOException e) {
            log.error("error caught:" + e.getMessage());
        }

        return offers;
    }


    private List<Offer> loadOffers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream empIs = getFileFromResourceAsStream("data/offers.json");

        return mapper.readValue(empIs, new TypeReference<List<Offer>>() {});

    }

    private InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
}
