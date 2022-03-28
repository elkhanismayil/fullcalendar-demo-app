package com.example.fullcalendardemoapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookingRestController {

    private final BookingService service;

    public BookingRestController(BookingService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<BookingDto> saveBook(@RequestBody BookingDto bookingDto) {
        BookingDto dto = service.create(bookingDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<BookingDto>> getBook(@PathVariable long id) {
        Optional<BookingDto> optionalBookingDto = service.getOne(id);
        return new ResponseEntity<>(optionalBookingDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingDto>> getAll() {
        List<BookingDto> allEvent = service.getAllEvent();
        return new ResponseEntity<>(allEvent, HttpStatus.OK);
    }
}
