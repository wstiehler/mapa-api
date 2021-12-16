package br.com.unicesumar.mapa.controller.form;

import br.com.unicesumar.mapa.model.Booking;
import br.com.unicesumar.mapa.model.HotelGuest;
import br.com.unicesumar.mapa.model.Suite;
import br.com.unicesumar.mapa.repository.BookingRepository;
import br.com.unicesumar.mapa.repository.HotelGuestRepository;
import br.com.unicesumar.mapa.repository.SuiteRepositoy;

public class BookingForm {
    private Integer dailyQuantily;
    private Integer personQuantily;
    private Double value;
    private String suiteType;
    private String hotelGestName;

    public Integer getDailyQuantily() {
        return dailyQuantily;
    }

    public void setDailyQuantily(Integer dailyQuantily) {
        this.dailyQuantily = dailyQuantily;
    }

    public Integer getPersonQuantily() {
        return personQuantily;
    }

    public void setPersonQuantily(Integer personQuantily) {
        this.personQuantily = personQuantily;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getSuiteType() {
        return suiteType;
    }

    public void setSuiteType(String suiteType) {
        this.suiteType = suiteType;
    }

    public String getHotelGestName() {
        return hotelGestName;
    }

    public void setHotelGestName(String hotelGestName) {
        this.hotelGestName = hotelGestName;
    }

    public Booking converter(SuiteRepositoy suiteRepositoy, HotelGuestRepository hotelGuestRepository) {
        Suite suite = suiteRepositoy.findByType(suiteType);
        HotelGuest hotelGuest = hotelGuestRepository.findByName(hotelGestName);
        return new Booking(dailyQuantily, personQuantily, value, suite, hotelGuest);
    }
}