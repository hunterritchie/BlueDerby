package bluederby.model;

public class Group
{
    private String m_groupName;
    private int m_groupId;

    public Group(String groupName)
    {
        m_groupName = groupName;
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
}

