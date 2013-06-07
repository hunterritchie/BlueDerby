
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

import bluederby.Membership;
import bluederby.MembershipType;

public class MembershipTest
{
    @Test
    public void defaultConstructor()
    {
        Membership membership = new Membership();
    }

    @Test
    public void createMembership()
    {
        MembershipType membershipType = MembershipType.GOLD;
        Membership membership = new Membership(membershipType, 0.75);
        membership.setMembershipId(1);

        int membershipId = membership.getMembershipId();
        MembershipType mt = membership.getMembershipType();
        double memberDiscount = membership.getMemberDiscount();

        assertEquals(mt, MembershipType.GOLD);
        assertEquals(membershipId, 1);
        assertEquals(memberDiscount, 0.75, 0);
    }
}

