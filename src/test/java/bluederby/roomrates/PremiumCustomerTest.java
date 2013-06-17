package bluederby.roomrates;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.runtime.StatelessKnowledgeSession;

import bluederby.model.BedType;
import bluederby.model.Guest;
import bluederby.model.Membership;
import bluederby.model.MembershipType;
import bluederby.model.Reservation;
import bluederby.service.KnowledgeBaseService;

public class PremiumCustomerTest {

	//As the owner, I want room 
	//rates to be adjusted for premium (repeat) customers.
	
	private StatelessKnowledgeSession session;
	private Guest guest;
	private Reservation reservation;
	private static final int DEFAULT_RATE = 100;
	static KnowledgeRuntimeLogger logger;
	
	public PremiumCustomerTest(){
		Membership membership = new Membership();
		guest = new Guest("Manchu","Foo",membership);
		reservation = new Reservation(guest,BedType.KING,DEFAULT_RATE,true,Calendar.getInstance(),Calendar.getInstance());
	}
	
	@Before
	public void resetSession(){
		session = KnowledgeBaseService.getInstance().newStatelessSession();
//		logger = KnowledgeRuntimeLoggerFactory.newConsoleLogger(session);
	}
	
	@Test
	public void testNonMemberCustomer() {
		session.execute(reservation);
		assertEquals(DEFAULT_RATE,reservation.getRate());
	}

	@Test
	public void testBlueMembership() {
		guest.getMembership().setStatus(MembershipType.BLUE);
		session.execute(reservation);
		assertEquals(DEFAULT_RATE,reservation.getRate());
	}

	@Test
	public void testSilverMembership() {
		guest.getMembership().setStatus(MembershipType.SILVER);
		session.execute(reservation);
		assertEquals((int)(DEFAULT_RATE * .9),reservation.getRate());
	}
	@Test
	public void testGoldMembership() {
		guest.getMembership().setStatus(MembershipType.GOLD);
		session.execute(reservation);
		assertEquals((int)(DEFAULT_RATE * .85),reservation.getRate());
	}
	@Test
	public void testPlatinumMembership() {
		guest.getMembership().setStatus(MembershipType.PLATINUM);
		session.execute(reservation);
		assertEquals((int)(DEFAULT_RATE * .8),reservation.getRate());
	}

}
