package br.com.unicesumar.mapa.controller;

import br.com.unicesumar.mapa.controller.dto.BookingDto;
import br.com.unicesumar.mapa.controller.form.BookingForm;
import br.com.unicesumar.mapa.model.Booking;
import br.com.unicesumar.mapa.model.HotelGuest;
import br.com.unicesumar.mapa.model.Suite;
import br.com.unicesumar.mapa.repository.BookingRepository;
import br.com.unicesumar.mapa.repository.HotelGuestRepository;
import br.com.unicesumar.mapa.repository.SuiteRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SuiteRepositoy suiteRepositoy;

    @Autowired
    private HotelGuestRepository hotelGuestRepository;

    @GetMapping
    public List<BookingDto> list(String hotelGuestName){
        if (hotelGuestName == null){
            List<Booking> bookings = bookingRepository.findAll();
            return BookingDto.converter(bookings);
        }else {
            List<Booking> bookings = bookingRepository.findByHotelGuestName(hotelGuestName);
            return BookingDto.converter(bookings);
        }
    }

    @PostMapping
    public void create(@RequestBody BookingForm form){
        Booking booking = form.converter(suiteRepositoy, hotelGuestRepository);
        Suite suite = new Suite();
        HotelGuest hotelGuest = new HotelGuest();
        validate(booking, suite, hotelGuest);
        valueBooking(booking, suite);
        bookingRepository.save(booking);

    }

    public Object validate(Booking booking, Suite suite, HotelGuest hotelGuest){
        if (booking.getPersonQuantily() <= suite.getCapacity()){
            return "capacity higher than expected!";
        }
        if (booking.getDailyQuantily() >= 7){
            double rebate = 10;
            double value = suite.getValue() - (suite.getValue() * rebate);
            Object valueRebate = booking.setValue(value);
            return valueRebate;
        }
        if (hotelGuest.getAge() <= 2){
            return booking.getPersonQuantily() - 1;
        }

        return validate(booking, suite, hotelGuest);
    }

    public Object valueBooking(Booking booking, Suite suite){
        double valueBooking = booking.getDailyQuantily() * suite.getValue();
        return booking.setValue(valueBooking);
    }

}
