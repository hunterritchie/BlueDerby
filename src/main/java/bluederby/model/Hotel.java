package bluederby.model;

import java.util.ArrayList;
import java.util.Calendar;

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
        
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = startDate;
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
        double groupRateFactor = 0.70;
        
        Group group = new Group(groupName, groupRateFactor);
        addGroup(group);

        groupName = "Redskins";
        groupRateFactor = 0.80;

        group = new Group(groupName, groupRateFactor);
        addGroup(group);
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
    
}

