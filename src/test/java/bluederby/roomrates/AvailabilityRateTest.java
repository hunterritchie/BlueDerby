package bluederby.roomrates;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.*;
import org.drools.runtime.*;
import org.drools.runtime.rule.*;
import org.drools.io.*;
//import org.jbpm.test.JbpmJUnitTestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;

import bluederby.model.*;

public class AvailabilityRateTest { //extends JbpmJUnitTestCase{

	private static KnowledgeBase kbase;
	private static StatefulKnowledgeSession ksession;
    private static FactHandle hotelHandle;
	

    @Before
    public void init() throws Exception {
        // setup knowledge base package with rules
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add( ResourceFactory.newClassPathResource("AvailabilityAdjustedRate.drl", getClass()), ResourceType.DRL);

        if (kbuilder.hasErrors()){ System.err.println(kbuilder.getErrors().toString()); }

        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());

        // start session
        ksession = kbase.newStatefulKnowledgeSession();

        Hotel hotel = new Hotel("Blue Derby", "wherever", 100.0);
        hotelHandle = ksession.insert(hotel);
	}


	@Test
	public void under_half() {
System.out.println("Test -0-");
        Hotel hotel = (Hotel)ksession.getObject(hotelHandle);

        Calendar startDate = new GregorianCalendar();
        Calendar endDate = new GregorianCalendar();
        endDate.add(Calendar.DAY_OF_YEAR, 1);

        for (int i=0; i<5; ++i) 
        { 
		    Reservation res = new Reservation(1, BedType.KING, 100.0, true, startDate, endDate, false);
            hotel.addReservation(res); 
            ksession.insert(res);
		    ksession.fireAllRules();
        }
        ksession.dispose();
	}

	@Test
	public void half_2_three_quarters() {
System.out.println("Test -1-");
        Hotel hotel = (Hotel)ksession.getObject(hotelHandle);

        Calendar startDate = new GregorianCalendar();
        Calendar endDate = new GregorianCalendar();
        endDate.add(Calendar.DAY_OF_YEAR, 1);

        for (int i=0; i<14; ++i) 
        { 
		    Reservation res = new Reservation(1, BedType.KING, 100.0, true, startDate, endDate, false);
            hotel.addReservation(res); 
            ksession.insert(res);
		    ksession.fireAllRules();
        }
        ksession.dispose();
	}

	@Test
	public void mostly_full() {
System.out.println("Test -2-");
        Hotel hotel = (Hotel)ksession.getObject(hotelHandle);

        Calendar startDate = new GregorianCalendar();
        Calendar endDate = new GregorianCalendar();
        endDate.add(Calendar.DAY_OF_YEAR, 1);

        for (int i=0; i<19; ++i) 
        { 
		    Reservation res = new Reservation(1, BedType.KING, 100.0, true, startDate, endDate, false);
            hotel.addReservation(res); 
            ksession.insert(res);
		    ksession.fireAllRules();
        }
        ksession.dispose();
	}


	@Test
	public void overbooking() {
System.out.println("Test -3-");
        Hotel hotel = (Hotel)ksession.getObject(hotelHandle);

        Calendar startDate = new GregorianCalendar();
        Calendar endDate = new GregorianCalendar();
        endDate.add(Calendar.DAY_OF_YEAR, 1);

        for (int i=0; i<21; ++i) 
        { 
		    Reservation res = new Reservation(1, BedType.KING, 100.0, true, startDate, endDate, false);
            hotel.addReservation(res); 
            ksession.insert(res);
		    ksession.fireAllRules();
        }
        ksession.dispose();
	}

}
