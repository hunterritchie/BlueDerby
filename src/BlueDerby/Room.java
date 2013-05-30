package bluederby;

import java.io.Serializable;
import java.util.ArrayList;

public class Room
{
    private int m_roomNumber;
    private int m_floor;
    private BedType m_bedType;
    private boolean m_nearElevator;
    private boolean m_nearIceMachine;
    private float m_roomTypeFactor;
    private ArrayList<Amenity> m_amenities;

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

    public float getRoomTypeFactor()
    {
        return m_roomTypeFactor;
    }
    public void setRoomTypeFactor(float roomTypeFactor)
    {
        m_roomTypeFactor = roomTypeFactor;
    }

    public ArrayList getAmenities()
    {
        return m_amenities;
    }
    public void setAmenities(ArrayList amenities)
    {
        m_amenities = amenities;
    }

}

