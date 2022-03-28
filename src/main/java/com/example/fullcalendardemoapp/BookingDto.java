package com.example.fullcalendardemoapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.Date;

@Data
public class BookingDto {

    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonProperty("start_date")
    private Date start;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonProperty("end_date")
    private Date end;

    @JsonProperty("title")
    private String title;
}
