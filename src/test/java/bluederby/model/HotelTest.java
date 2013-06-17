package bluederby.model;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

import bluederby.model.Hotel;

public class HotelTest
{
    @Test
    public void createHotel()
    {

        Hotel hotel = new Hotel("Blue Derby Hotel", "8260 Greensboro Dr.", 125);

        String name = hotel.getName();
        String address = hotel.getAddress();

        double rate = hotel.getBaseRoomRate();
        int numberOfRooms = hotel.getNumberOfRooms();

        assertEquals("Blue Derby Hotel", name);
        assertEquals("8260 Greensboro Dr.", address);

        assertEquals(rate, 125, 0.001);
        assertEquals(numberOfRooms, 20);
    }
}

