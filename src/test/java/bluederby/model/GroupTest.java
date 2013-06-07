
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

import bluederby.Group;

public class GroupTest
{
    @Test
    public void defaultConstructor()
    {
        Group group = new Group();
    }

    @Test
    public void createGroup()
    {
        Group group = new Group("testgroup", 0.75);
        group.setGroupId(1);

        int groupId = group.getGroupId();
        String groupName = group.getGroupName();
        double groupRateFactor = group.getGroupRateFactor();

        assertEquals("failure - groupName not set", groupName, "testgroup");
        assertEquals(groupId, 1);
        assertEquals(groupRateFactor, 0.75, 0);
    }
}

