package bluederby.scheduling;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.drools.builder.ResourceType;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Before;
import org.junit.Test;

import bluederby.model.BedType;
import bluederby.model.Group;
import bluederby.model.Guest;
import bluederby.model.Hotel;
import bluederby.model.Membership;
import bluederby.model.Reservation;
import bluederby.rules.test.RulesTestBase;

public class FillFactorTest extends RulesTestBase {

	@Override
	public Map<String, ResourceType> getResourceList() {
		Map<String, ResourceType> resources = new HashMap<String, ResourceType>();
		resources.put("FillFactor.drl", ResourceType.DRL);
		return resources;
	}

	// As the owner, I want group rates thru start and end dates

	private StatelessKnowledgeSession session;
	private Guest guest;
	private Group group;
	private Hotel hotel;
	private Reservation reservation;
	private Membership membership;
	private static final double DEFAULT_RATE = 100;
	static KnowledgeRuntimeLogger logger;

	public FillFactorTest(){
		// Create Hotel
		hotel = new Hotel("BlueDerby", "123 Sesame St", DEFAULT_RATE);
		membership = new Membership();
	}

	@Before
	public void resetSession(){
		session = newStatelessSession();
	}

	@Test
	public void testEmptyHotelRate() {
		try 
		{	
			// Create Guest
			guest = new Guest("Manchu","Foo", -1, -1);
			hotel.addGuest(guest);

			// Create Reservation
			boolean guaranteed = true;
			reservation = new Reservation(guest,BedType.QUEEN,DEFAULT_RATE,guaranteed,Calendar.getInstance(),Calendar.getInstance(), false);

			session.execute(reservation);
			assertTrue(reservation.getIsGuaranteed());
		}
		catch (Throwable t) 
		{
			t.printStackTrace();
			fail(t.getMessage());
		}
	}

	@Test
	public void testFullHotelRate() {
		FillHotel(1.0);

		// Create Guest
		guest = new Guest("Manchu","Foo", -1, -1);
		hotel.addGuest(guest);

		// Create Reservation
		boolean guaranteed = true;
		reservation = new Reservation(guest,BedType.QUEEN,DEFAULT_RATE,guaranteed,Calendar.getInstance(),Calendar.getInstance(), false);

		session.setGlobal("hotel", hotel);
		session.execute(reservation);
		assertFalse(reservation.getIsGuaranteed());
	}

	private void FillHotel(double fillRate) {
		int numRooms = (int) (hotel.getRooms().size() * fillRate);

		Guest filler = new Guest("The Room", "Taker", -1, -1);
		hotel.addGuest(filler);
		for (int i = 0; i < numRooms; i++) {
			hotel.addReservation(new Reservation(filler, BedType.QUEEN, DEFAULT_RATE, true, Calendar.getInstance(), Calendar.getInstance(), false));
		}
	}
}
