package bluederby;

import java.io.Serializable;

public class Membership
{
    private int m_memberId;
    private MembershipType m_membershipType;
    private float m_memberDiscount;

    public int getMemberId()
    {
        return m_memberId;
    }
    public void setMemberId(int memberId)
    {
        m_memberId = memberId;
    }

    public MembershipType getMembershipType()
    {
        return m_membershipType;
    }
    public void setMembershipType(MembershipType membershipType)
    {
        m_membershipType = membershipType;
    }

    public float getMemberDiscount()
    {
        return m_memberDiscount;
    }
    public void setMemberDiscount(float memberDiscount)
    {
        m_memberDiscount = memberDiscount;
    }

}

