package bluederby;

public class Guest
{
    private int m_guestId;
    private String m_lastName;
    private String m_firstName;
    private int m_groupId;
    private int m_memberId;

    public Guest(String lastName, String firstName, int groupId, int memberId)
    {
        m_lastName = lastName;
        m_firstName = firstName;
        m_groupId = groupId;
        m_memberId = memberId;
    }

    public Guest() {}

    public int getGuestId()
    {
        return m_guestId;
    }
    public void setGuestId(int guestId)
    {
        m_guestId = guestId;
    }

    public String getLastName()
    {
        return m_lastName;
    }
    public void setLastName(String lastName)
    {
        m_lastName = lastName;
    }

    public String getFirstName()
    {
        return m_firstName;
    }
    public void setFirstName(String firstName)
    {
        m_firstName = firstName;
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

