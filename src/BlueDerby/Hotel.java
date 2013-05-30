package bluederby;

import java.io.Serializable;
import java.util.ArrayList;

public class Hotel
{
    private String m_name;
    private String m_address;
    private int m_baseRoomRate;
    private int m_numberOfRooms;

    private ArrayList<Room> m_rooms;
    private ArrayList<Reservation> m_reservations;
    private ArrayList<Guest> m_guests;
    private ArrayList<Membership> m_memberships;
    private ArrayList<Group> m_groups;


    public String getName()
    {
        return m_name;
    }
    public void setName(String name)
    {
        m_name = name;
    }

    public String getAddress()
    {
        return m_address;
    }
    public void setAddress(String address)
    {
        m_address = address;
    }

    public int getBaseRoomRate()
    {
        return m_baseRoomRate;
    }
    public void setBaseRoomRate(int baseRoomRate)
    {
        m_baseRoomRate = baseRoomRate;
    }

    public int getNumberOfRooms()
    {
        return m_numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms)
    {
        m_numberOfRooms = numberOfRooms;
    }

    public ArrayList getRooms()
    {
        return m_rooms;
    }
    public void setRooms(ArrayList rooms)
    {
        m_rooms = rooms;
    }

    public ArrayList getReservations()
    {
        return m_reservations;
    }
    public void setReservations(ArrayList reservations)
    {
        m_reservations = reservations;
    }

    public ArrayList getGuests()
    {
        return m_guests;
    }
    public void setGuests(ArrayList guests)
    {
        m_guests = guests;
    }

    public ArrayList getMemberships()
    {
        return m_memberships;
    }
    public void setMemberships(ArrayList memberships)
    {
        m_memberships = memberships;
    }

    public ArrayList getGroups()
    {
        return m_groups;
    }
    public void setGroups(ArrayList groups)
    {
        m_groups = groups;
    }

}

