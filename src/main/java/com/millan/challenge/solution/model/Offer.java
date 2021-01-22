package com.millan.challenge.solution.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Offer {

    @JsonProperty("offerID")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("details")
    private String details;

    @JsonProperty("claimLimit")
    private int claimLimit;

    @JsonProperty("offerExpiry")
    private String offerExpiry;
}
