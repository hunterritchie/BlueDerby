package bluederby;

public class Group
{
    private String m_groupName;
    private int m_groupId;
    private double m_groupRateFactor;

    public Group(String groupName, double groupRateFactor)
    {
        m_groupName = groupName;
        m_groupRateFactor = groupRateFactor;
    }

    public Group() {}

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

    public double getGroupRateFactor()
    {
        return m_groupRateFactor;
    }
    public void setGroupRateFactor(double groupRateFactor)
    {
        m_groupRateFactor = groupRateFactor;
    }

}

