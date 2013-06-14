package bluederby.model;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

import java.util.Calendar;
import java.util.GregorianCalendar;

import bluederby.model.Reservation;
import bluederby.model.BedType;

public class ReservationTest
{
    @Test
    public void defaultConstructor()
    {
        Reservation reservation = new Reservation();
    }

    @Test
    public void createReservation()
    {
        Calendar startDate = new GregorianCalendar(2013, 6, 7);
        Calendar endDate = new GregorianCalendar(2013, 6, 8);

        Reservation reservation = new Reservation(2, BedType.QUEEN, 125, true, startDate, endDate, false);
        reservation.setReservationId(1);

        int reservationId = reservation.getReservationId();
        int guestId = reservation.getGuestId();

        double rate = reservation.getBaseRate();
        BedType bedType = reservation.getBedType();

        boolean guaranteed = reservation.getIsGuaranteed();

        Calendar start = reservation.getStartDate();
        Calendar end = reservation.getEndDate();

        assertEquals(reservationId, 1);
        assertEquals(guestId, 2);
        assertEquals(bedType, BedType.QUEEN);

        assertEquals(true, guaranteed);

        assertEquals(startDate, start);
        assertEquals(endDate, end);
    }
}

