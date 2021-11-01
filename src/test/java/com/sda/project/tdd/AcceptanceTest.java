package com.sda.project.tdd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AcceptanceTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void acceptanceTest() {
        // given
        // create reservation
        Reservation reservation = new Reservation();
        // select check in
        reservation.setCheckIn(LocalDate.now());
        // select check out
        reservation.setCheckOut(LocalDate.now());
        // select number of travelers
        reservation.setTravelersCount(LocalDate.now());
        // select place
        reservation.setPlace(new Place("costinesti"));

        Reservation expected = new Reservation();
        expected.setId(1L);
        expected.setCheckIn(LocalDate.now());
        expected.setCheckOut(LocalDate.now());
        expected.setTravelersCount(LocalDate.now());
        expected.setPlace(new Place("costinesti"));

        // when
        // save reservation
        Reservation actual = reservationRepository.save(reservation);

        // then
        assertThat(actual).isEqualTo(expected);
        assertThat(actual.getId()).isEqualTo(expected.getId());
    }
}
