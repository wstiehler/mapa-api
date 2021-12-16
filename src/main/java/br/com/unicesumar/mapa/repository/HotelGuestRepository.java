package br.com.unicesumar.mapa.repository;

import br.com.unicesumar.mapa.model.Booking;
import br.com.unicesumar.mapa.model.HotelGuest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelGuestRepository extends JpaRepository<HotelGuest, Long> {

    HotelGuest findByName(String hotelGestName);
}
