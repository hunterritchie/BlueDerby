package bluederby.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class Hotel
{
    private String m_name;
    private String m_address;
    private double m_baseRoomRate;
    private int m_numberOfRooms;
    
    private ArrayList<Room> m_rooms;
    private ArrayList<Reservation> m_reservations;
    private ArrayList<Guest> m_guests;
    private ArrayList<Membership> m_memberships;
    private ArrayList<Group> m_groups;

    private HashMap<Calendar, Double> m_availabilityRates;


    public Hotel(String name, String address, double baseRoomRate)
    {
        m_name = name;
        m_address = address;
        m_baseRoomRate = baseRoomRate;

        m_rooms = new ArrayList<Room>();
        m_reservations = new ArrayList<Reservation>();
        m_guests = new ArrayList<Guest>();
        m_memberships = new ArrayList<Membership>();
        m_groups = new ArrayList<Group>();

        m_availabilityRates = new HashMap<Calendar, Double>();
            
        setupRooms();
        setupMemberships();
        setupGroups();
        setupGuests();
        setupReservations();

    }
    
    // default Hotel configuration
    private void setupRooms()
    {
        for(int floor=1; floor<=4; ++floor)
        {
            for(int room=1; room<=5; ++room)
            {
                int roomNumber = (floor*100) + room;

                boolean nearElevator = false;
                if (1 == room) { nearElevator = true; }

                boolean nearIceMachine = false;
                if (5 == room) { nearIceMachine = true; }

                BedType bedType = BedType.values()[room % BedType.values().length];

                Room aRoom = new Room(roomNumber, floor, bedType, nearElevator, nearIceMachine);
                addRoom(aRoom);
            }
        }
    }

    private void setupReservations()
    {
        int guestId = 0;
        for (Guest guest : m_guests)
        {
            if ("Doe" == guest.getLastName())
            {
                guestId = guest.getGuestId();
            }
        }
        
        Calendar startDate = new GregorianCalendar();
        Calendar endDate = new GregorianCalendar();
        endDate.add(Calendar.DAY_OF_YEAR, 7);
        
        BedType bedType = BedType.QUEEN;
        
        Reservation res = new Reservation(guestId, bedType, getBaseRoomRate(), false, startDate, endDate, false);
        addReservation(res);
    }

    private void setupGuests()
    {
        Guest guest = new Guest("Doe", "John", 0, 0);
        addGuest(guest);
    }

    private void setupMemberships()
    {
        for(int i=0; i < MembershipType.values().length; ++i)
        {
            MembershipType membershipType = MembershipType.values()[i];
            double memberDiscount = 0;
            switch (membershipType)
            {
                case SILVER:
                    memberDiscount = 0.90;
                    break;
                case GOLD:
                    memberDiscount = 0.85;
                    break;
                case PLATINUM:
                    memberDiscount = 0.80;
                    break;
                case AAA:
                    memberDiscount = 0.95;
                    break;
                case SENIOR:
                    memberDiscount = 0.95;
                    break;
                default:
            }

            Membership membership = new Membership(membershipType, memberDiscount);
            addMembership(membership);
        }
    }

    private void setupGroups()
    {
        String groupName = "Brigands";
        
        Group group = new Group(groupName);
        addGroup(group);

        groupName = "Redskins";

        group = new Group(groupName);
        addGroup(group);
    }

    public double getNumberOfReservationsOnDay(Calendar date)
    {
        double count = 0.0;
        Iterator ite = getReservations().iterator();
        Reservation res = new Reservation();
        while (ite.hasNext())
        {
            res = (Reservation)ite.next();
            if ( (0 >= res.getStartDate().compareTo(date)) && (0 <= res.getEndDate().compareTo(date)))
            {
                count += 1;
            }
        }
        return count;
    }

    public double getAvailabilityForDates(Calendar startDate, Calendar endDate)
    {
//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//System.out.format("getAvail start date      : %s%n", sdf.format(startDate.getTime()));
//System.out.format("getAvail end date        : %s%n", sdf.format(endDate.getTime()));

        double resCount = 0;

        Calendar start = (Calendar)startDate.clone();
        while (start.getTime().before(endDate.getTime()))
        {
            double count = getNumberOfReservationsOnDay(start);
            resCount = Math.max(count, resCount);
            start.add(Calendar.DAY_OF_YEAR, 1);
        }
//System.out.format("===--->> resCount = %d%n", resCount);
//System.out.format("getAvailAFTER start date      : %s%n", sdf.format(startDate.getTime()));
//System.out.format("getAvailAFTER end date        : %s%n", sdf.format(endDate.getTime()));
        return resCount;
    }

    public void setRateForDates(Calendar startDate, Calendar endDate, double rate)
    {
        Calendar start = (Calendar)startDate.clone();
        while (start.getTime().before(endDate.getTime()))
        {
            m_availabilityRates.put(start, new Double(rate));
            start.add(Calendar.DAY_OF_YEAR, 1);
        }
        return;
    }

    public double getRateForDates(Calendar startDate, Calendar endDate)
    {
        double rate = 0.0;
        double maxRate = 0.0;
        Calendar start = (Calendar)startDate.clone();
        while (start.getTime().before(endDate.getTime()))
        {
            rate = m_availabilityRates.get(start);
            maxRate = Math.max(rate, maxRate);
        }
        return maxRate;
    }



    // accessors
    public String getName()
    {
        return m_name;
    }

    public String getAddress()
    {
        return m_address;
    }

    public double getBaseRoomRate()
    {
        return m_baseRoomRate;
    }

    public int getNumberOfRooms()
    {
        return m_numberOfRooms;
    }
    private void setNumberOfRooms(int numberOfRooms)
    {
        m_numberOfRooms = numberOfRooms;
    }

    public ArrayList<Room> getRooms()
    {
        return m_rooms;
    }

    public ArrayList<Reservation> getReservations()
    {
        return m_reservations;
    }

    public ArrayList<Guest> getGuests()
    {
        return m_guests;
    }

    public ArrayList<Membership> getMemberships()
    {
        return m_memberships;
    }

    public ArrayList<Group> getGroups()
    {
        return m_groups;
    }


    // mutators
    public void addRoom(Room room)
    {
        int numberOfRooms = m_rooms.size();
        ++numberOfRooms;
        setNumberOfRooms(numberOfRooms);
        m_rooms.add(room);
    }

    public void addReservation(Reservation reservation)
    {
        int numberOfReservations = m_reservations.size();
        ++numberOfReservations;
        reservation.setReservationId(numberOfReservations);
        m_reservations.add(reservation);
    }

    public void addGuest(Guest guest)
    {
        int numberOfGuests = m_guests.size();
        ++numberOfGuests;
        guest.setGuestId(numberOfGuests);
        m_guests.add(guest);
    }

    public void addMembership(Membership membership)
    {
        int numberOfMemberships = m_memberships.size();
        ++numberOfMemberships;
        membership.setMembershipId(numberOfMemberships);
        m_memberships.add(membership);
    }

    public void addGroup(Group group)
    {
        int numberOfGroups = m_groups.size();
        ++numberOfGroups;
        group.setGroupId(numberOfGroups);
        m_groups.add(group);
    }
    
    public Group findGroupById(int id)
    {
    	Group return_group = null;
    	for (int i = 0; i < m_groups.size(); i++)
    	{
    		Group group = m_groups.get(i);
    		if (group.getGroupId() == id)
    		{
    			return_group = group;
    		}
    	}
    	return return_group;
    }
    
    public Group findGroupByName(String name)
    {
    	Group return_group = null;
    	for (int i = 0; i < m_groups.size(); i++)
    	{
    		Group group = m_groups.get(i);
    		if (group.getGroupName().compareTo(name) == 0)
    		{
    			return_group = group;
    		}
    	}
    	return return_group;
    }

}

