package br.com.unicesumar.mapa.model;

import javax.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer dailyQuantily;
    private Integer personQuantily;

    public Booking(Integer dailyQuantily, Integer personQuantily, Double value, Suite suite, HotelGuest hotelGuest) {
        this.dailyQuantily = dailyQuantily;
        this.personQuantily = personQuantily;
        this.value = value;
        this.suite = suite;
        this.hotelGuest = hotelGuest;
    }

    private Double value;
    @ManyToOne
    private Suite suite;
    @ManyToOne
    private HotelGuest hotelGuest;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Booking other = (Booking) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public Integer getDailyQuantily(){
        return dailyQuantily;
    }
    public void setDailyQuantily(Integer dailyQuantily){
        this.dailyQuantily = dailyQuantily;
    }
    public Integer getPersonQuantily(){
        return personQuantily;
    }
    public void setPersonQuantily(Integer personQuantily){
        this.personQuantily = personQuantily;
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
    public Double getValue() {
        return value;
    }
    public Object setValue(Double value) {
        this.value = value;
        return null;
    }

}

