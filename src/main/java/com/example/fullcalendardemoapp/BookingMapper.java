package com.example.fullcalendardemoapp;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(source = "startDate", target = "start")
    @Mapping(source = "endDate", target = "end")
    BookingDto entityToDto(Booking booking);

    List<BookingDto> toDtoList(List<Booking> bookings);

    List<Booking> dtoToEntityList(List<BookingDto> bookingDtos);

    @InheritInverseConfiguration
    Booking dtoToEntity(BookingDto bookingDto);
}
