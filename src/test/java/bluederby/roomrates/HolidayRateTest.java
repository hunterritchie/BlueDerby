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

public class HolidayRateTest {

	//As the owner, I want room rates
	//to be adjusted for holidays
	
	private StatelessKnowledgeSession session;
	private Guest guest;
	private Reservation reservation;
	private static final double DEFAULT_RATE = 100.0;
	
	public HolidayRateTest(){
		Membership membership = new Membership();
		guest = new Guest("Christmas","Eve",membership);
		reservation = new Reservation(guest,BedType.KING,DEFAULT_RATE,true,Calendar.getInstance(),Calendar.getInstance(),false);
	}
	
	@Before
	public void resetSession(){
		session = KnowledgeBaseService.getInstance().newStatelessSession();
	}
	
	@Test
	public void testHolidayRate() {
		reservation.setIsHoliday(true);
		session.execute(reservation);
		assertEquals(DEFAULT_RATE,reservation.getCalculatedRate(),30);
	}
	
	@Test
	public void testNonHolidayRate() {
		reservation.setIsHoliday(false);
		session.execute(reservation);
		assertEquals(DEFAULT_RATE,reservation.getCalculatedRate(),0);
	}
	
}
