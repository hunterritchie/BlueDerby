package bluederby.model;

public class Guest
{
    private int m_guestId;
    private String m_lastName;
    private String m_firstName;
    private int m_groupId;
    private int m_membershipId;
	private Membership m_membership;

    public Guest(String lastName, String firstName, int groupId, int membershipId)
    {
        m_lastName = lastName;
        m_firstName = firstName;
        m_groupId = groupId;
        m_membershipId = membershipId;
    }

    public Guest() {}

    public Guest(String lastName, String firstName, Membership membership) {
		m_lastName = lastName;
		m_firstName = firstName;
		m_membership = membership;
	}

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

    public int getMembershipId()
    {
        return m_membershipId;
    }
    public void setMembershipId(int membershipId)
    {
        m_membershipId = membershipId;
    }

	public Membership getMembership() {
		return m_membership;
	}

}

