package bluederby.model;

import java.util.ArrayList;

public class Room
{
    private int m_roomNumber;
    private int m_floor;
    private BedType m_bedType;
    private boolean m_nearElevator;
    private boolean m_nearIceMachine;
    private ArrayList<Amenity> m_amenities;

    public Room(int roomNumber, int floor, BedType bedType, boolean nearElevator, boolean nearIceMachine)
    {
        m_roomNumber = roomNumber;
        m_floor = floor;
        m_bedType = bedType;
        m_nearElevator = nearElevator;
        m_nearIceMachine = nearIceMachine;
    }


    public Room(BedType bedType, boolean nearElevator, boolean nearIceMachine)
    {
        m_bedType = bedType;
        m_nearElevator = nearElevator;
        m_nearIceMachine = nearIceMachine;
    }

    public Room()
    {
        m_amenities = new ArrayList<Amenity>();
    }

    public int getRoomNumber()
    {
        return m_roomNumber;
    }
    public void setRoomNumber(int roomNumber)
    {
        m_roomNumber = roomNumber;
    }

    public int getFloor()
    {
        return m_floor;
    }
    public void setFloor(int floor)
    {
        m_floor = floor;
    }

    public BedType getBedType()
    {
        return m_bedType;
    }
    public void setBedType(BedType bedType)
    {
        m_bedType = bedType;
    }

    public boolean getNearElevator()
    {
        return m_nearElevator;
    }
    public void setNearElevator(boolean nearElevator)
    {
        m_nearElevator = nearElevator;
    }

    public boolean getNearIceMachine()
    {
        return m_nearIceMachine;
    }
    public void setNearIceMachine(boolean nearIceMachine)
    {
        m_nearIceMachine = nearIceMachine;
    }

    public ArrayList<Amenity> getAmenities()
    {
        return m_amenities;
    }
    public void setAmenities(ArrayList<Amenity> amenities)
    {
        m_amenities = amenities;
    }
    public void addAmenity(Amenity amenity)
    {
        m_amenities.add(amenity);
    }

}

