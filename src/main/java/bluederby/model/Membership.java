package bluederby;

public class Membership
{
    private int m_membershipId;
    private MembershipType m_membershipType;
    private double m_memberDiscount;

    public Membership(MembershipType membershipType, double memberDiscount)
    {
        m_membershipType = membershipType;
        m_memberDiscount = memberDiscount;
    }

    public Membership() {}

    public int getMembershipId()
    {
        return m_membershipId;
    }
    public void setMembershipId(int membershipId)
    {
        m_membershipId = membershipId;
    }

    public MembershipType getMembershipType()
    {
        return m_membershipType;
    }
    public void setMembershipType(MembershipType membershipType)
    {
        m_membershipType = membershipType;
    }

    public double getMemberDiscount()
    {
        return m_memberDiscount;
    }
    public void setMemberDiscount(double memberDiscount)
    {
        m_memberDiscount = memberDiscount;
    }

}

