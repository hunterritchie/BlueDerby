package bluederby.hotelrules;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.builder.ResourceType;
import org.drools.runtime.*;
import org.jbpm.test.JbpmJUnitTestCase;

import org.junit.Before;
import org.junit.Test;

import bluederby.model.Reservation;

public class HolidayRate extends JbpmJUnitTestCase{

	private static KnowledgeBase kbase;
	private static StatefulKnowledgeSession ksession;
	
	@Before
	public void setUp() throws Exception {
		Map<String, ResourceType> kbtypes = new HashMap<String, ResourceType>();
		kbtypes.put("hotelrate.drl", ResourceType.DRL);
		
		kbase = null;
		try	{
			kbase = createKnowledgeBase(kbtypes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ksession = createKnowledgeSession();
	}

	@Test
	public void test() {
		Reservation res = new Reservation();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("reservation", res);
		
		ksession.startProcess("holidayrate");
	}

}
