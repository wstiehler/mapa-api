package br.com.unicesumar.mapa.controller.dto;

import br.com.unicesumar.mapa.model.Booking;
import br.com.unicesumar.mapa.model.HotelGuest;
import br.com.unicesumar.mapa.model.Suite;

import java.util.List;
import java.util.stream.Collectors;

public class BookingDto {
    private Long id;
    private Integer dailyQuantily;
    private Integer personQuantily;
    private Suite suite;
    private HotelGuest hotelGuest;

    public BookingDto(Booking booking){
        this.id = booking.getId();
        this.dailyQuantily = booking.getDailyQuantily();
        this.personQuantily = booking.getPersonQuantily();
        this.suite = booking.getSuite();
        this.hotelGuest = booking.getHotelGuest();
    }

    public static List<BookingDto> converter(List<Booking> bookings) {
        return bookings.stream().map(BookingDto::new).collect(Collectors.toList());
    }

    public Long getId(){
        return id;
    }
    public Integer getDailyQuantily(){
        return dailyQuantily;
    }
    public Integer getPersonQuantily(){
        return personQuantily;
    }
    public Suite getSuite(){
        return suite;
    }
    public void setSuite(Suite suite){
        this.suite = suite;
    }
    public HotelGuest getHotelGuest(){
        return hotelGuest;
    }
    public void setHotelGuest(HotelGuest hotelGuest){
        this.hotelGuest = hotelGuest;
    }
}

