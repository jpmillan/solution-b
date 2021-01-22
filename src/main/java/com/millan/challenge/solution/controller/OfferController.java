package com.millan.challenge.solution.controller;

import com.millan.challenge.solution.model.Offer;
import com.millan.challenge.solution.service.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/member/me")
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @Secured("ROLE_USER")
    @RequestMapping(method = RequestMethod.GET, path = "/offers")
    public ResponseEntity<List<Offer>> getMemberOffers() {
        return ResponseEntity.ok(offerService.getOffers());
    }

}
