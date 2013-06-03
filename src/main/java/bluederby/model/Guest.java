package bluederby;

import java.io.Serializable;


public class Guest
{
    private String m_name;
    private int m_reservationId;
    private int m_groupId;
    private int m_memberId;


    public String getName()
    {
        return m_name;
    }
    public void setName(String name)
    {
        m_name = name;
    }

    public int getReservationId()
    {
        return m_reservationId;
    }
    public void setReservationId(int reservationId)
    {
        m_reservationId = reservationId;
    }

    public int getGroupId()
    {
        return m_groupId;
    }
    public void setGroupId(int groupId)
    {
        m_groupId = groupId;
    }

    public int getMemberId()
    {
        return m_memberId;
    }
    public void setMemberId(int memberId)
    {
        m_memberId = memberId;
    }

}

