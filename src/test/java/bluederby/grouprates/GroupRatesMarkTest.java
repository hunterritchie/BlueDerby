package bluederby.grouprates;

import static org.junit.Assert.assertEquals;

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
import bluederby.rules.test.BaseRulesTest;

public class GroupRatesMarkTest extends BaseRulesTest {

	@Override
	public Map<String, ResourceType> getResourceList() {
		Map<String, ResourceType> resources = new HashMap<String, ResourceType>();
		resources.put("GroupRates.drl", ResourceType.DRL);
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
	
	public GroupRatesMarkTest(){
		// Create Hotel
		hotel = new Hotel("BlueDerby", "123 Sesame St", DEFAULT_RATE);
		membership = new Membership();
	}
	
	@Before
	public void resetSession(){
		session = newStatelessSession();
	}
	
	@Test
	public void testBrigandsGroupRate() {
		try 
		{
			group = hotel.findGroupByName("Brigands");
			
			// Create Guest
			guest = new Guest("Manchu","Foo",group);
			guest.setMembership(membership);
			hotel.addGuest(guest);
			
			// Create Reservation
			reservation = new Reservation(guest,BedType.QUEEN,DEFAULT_RATE,true,Calendar.getInstance(),Calendar.getInstance(), false);
			hotel.addReservation(reservation);
			
			session.execute(reservation);
			assertEquals((int)(DEFAULT_RATE*0.7),(int)reservation.getCalculatedRate());
		}
		catch (Throwable t) 
		{
			t.printStackTrace();
		}
	}

}
