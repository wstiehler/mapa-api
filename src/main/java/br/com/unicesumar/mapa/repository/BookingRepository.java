package br.com.unicesumar.mapa.repository;

import br.com.unicesumar.mapa.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByHotelGuestName(String hotelGuestName);
}