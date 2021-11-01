package com.sda.project.tdd;

import java.time.LocalDate;

public class Reservation {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private LocalDate travelersCount;
    private Place place;
    private long id;

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setTravelersCount(LocalDate travelersCount) {
        this.travelersCount = travelersCount;
    }

    public LocalDate getTravelersCount() {
        return travelersCount;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
