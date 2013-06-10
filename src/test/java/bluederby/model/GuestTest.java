package bluederby.model;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

import bluederby.model.Guest;

public class GuestTest
{
    @Test
    public void defaultConstructor()
    {
        Guest guest = new Guest();
    }

    @Test
    public void createGuest()
    {
        Guest guest = new Guest("Doe", "John", 2, 3);
        guest.setGuestId(1);

        int guestId = guest.getGuestId();
        int groupId = guest.getGroupId();
        int membershipId = guest.getMembershipId();

        String lastName = guest.getLastName();
        String firstName = guest.getFirstName();

        assertEquals(guestId, 1);
        assertEquals(groupId, 2);
        assertEquals(membershipId, 3);

        assertEquals("failure - lastName not set", lastName, "Doe");
        assertEquals("failure - firstName not set", firstName, "John");
    }
}

