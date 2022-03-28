package com.example.fullcalendardemoapp;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    BookingDto create(BookingDto bookingDto);

    Optional<BookingDto> getOne(long id);

    List<BookingDto> getAllEvent();
}
