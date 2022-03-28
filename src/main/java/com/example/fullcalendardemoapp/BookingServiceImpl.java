package com.example.fullcalendardemoapp;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;
    private final BookingMapper mapper;

    public BookingServiceImpl(BookingRepository repository, BookingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BookingDto create(BookingDto bookingDto) {
        Booking booking = mapper.dtoToEntity(bookingDto);
        Booking saved = repository.save(booking);
        return mapper.entityToDto(saved);
    }

    @Override
    public Optional<BookingDto> getOne(long id) {
        Booking booking = repository.findById(id).get();
        return Optional.ofNullable(mapper.entityToDto(booking));
    }

    @Override
    public List<BookingDto> getAllEvent() {
        List<Booking> all = repository.findAll();
        return mapper.toDtoList(all);
    }
}
