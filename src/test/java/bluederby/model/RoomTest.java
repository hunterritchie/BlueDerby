package bluederby.model;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;

import bluederby.model.Room;
import bluederby.model.Amenity;
import bluederby.model.BedType;

public class RoomTest
{
    @Test
    public void defaultConstructor()
    {
        Room room = new Room();
    }

    @Test
    public void createRoom()
    {
        ArrayList<Amenity> amenityList = new ArrayList<Amenity>();
        amenityList.add(Amenity.TV);
        amenityList.add(Amenity.MINIFRIDGE);

        BedType bedType = BedType.KING;

        Room room = new Room(1, 2, bedType, false, true);
        room.setAmenities(amenityList);

        int roomNumber = room.getRoomNumber();
        int floor = room.getFloor();
        BedType bt = room.getBedType();

        boolean ice = room.getNearIceMachine();
        boolean lift = room.getNearElevator();

        ArrayList<Amenity> addons = room.getAmenities();

        assertEquals(roomNumber, 1);
        assertEquals(floor, 2);
        assertEquals(bt, BedType.KING);

        assertEquals(true, ice);
        assertEquals(false, lift);

        assertEquals(true, addons.contains(Amenity.TV));
        assertEquals(true, addons.contains(Amenity.MINIFRIDGE));
    }
}

