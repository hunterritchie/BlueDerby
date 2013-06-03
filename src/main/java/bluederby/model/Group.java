package bluederby;

import java.io.Serializable;

public class Group
{
    private int m_groupId;
    private String m_groupName;
    private float m_groupRateFactor;

    public int getGroupId()
    {
        return m_groupId;
    }
    public void setGroupId(int groupId)
    {
        m_groupId = groupId;
    }

    public String getGroupName()
    {
        return m_groupName;
    }
    public void setGroupName(String groupName)
    {
        m_groupName = groupName;
    }

    public float getGroupRateFactor()
    {
        return m_groupRateFactor;
    }
    public void setGroupRateFactor(float groupRateFactor)
    {
        m_groupRateFactor = groupRateFactor;
    }

}

