package bluederby.roomrates;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.drools.runtime.StatelessKnowledgeSession;

import bluederby.model.BedType;
import bluederby.model.Guest;
import bluederby.model.Membership;
import bluederby.model.Reservation;
import bluederby.service.KnowledgeBaseService;

public class RoomTypeTest {

	//As the owner, I want room rates
	//to be adjusted for the type of Room.
	
	private StatelessKnowledgeSession session;
	private Guest guest;
	private Reservation reservation;
	private static final double DEFAULT_RATE = 100.0;
	
	public RoomTypeTest(){
		Membership membership = new Membership();
		guest = new Guest("Manchu","Foo",membership);
		reservation = new Reservation(guest,BedType.KING,DEFAULT_RATE,true,Calendar.getInstance(),Calendar.getInstance(),false);
	}
	
	@Before
	public void resetSession(){
		session = KnowledgeBaseService.getInstance().newStatelessSession();
	}
	
	@Test
	public void testQueenBed() {
		reservation.setBedType(BedType.QUEEN);
		session.execute(reservation);
		assertEquals(DEFAULT_RATE,reservation.getBaseRate(), 0.01);
	}

	@Test
	public void testTwoQueenBed() {
		reservation.setBedType(BedType.TWO_QUEEN);
		session.execute(reservation);
		assertEquals((DEFAULT_RATE + 25),reservation.getBaseRate(), 0.01);
	}

	@Test
	public void testKingBed() {
		session.execute(reservation);
		assertEquals((DEFAULT_RATE + 50),reservation.getBaseRate(), 0.01);
	}
	
}
