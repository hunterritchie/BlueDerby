
package bluederby.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

import bluederby.model.Group;


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
        Group group = new Group("testgroup");
        group.setGroupId(1);

        int groupId = group.getGroupId();
        String groupName = group.getGroupName();

        assertEquals("failure - groupName not set", groupName, "testgroup");
        assertEquals(groupId, 1);
    }
}

