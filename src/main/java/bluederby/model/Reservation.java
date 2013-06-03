package bluederby;

import java.io.Serializable;
import java.util.Calendar;


public class Reservation
{
    private int m_reservationId;
    private int m_rate;
    private boolean m_isGuaranteed;
    private boolean m_nearIceMachine;
    private Calendar m_startDate;
    private Calendar m_endDate;

    public int getReservationId()
    {
        return m_reservationId;
    }
    public void setReservationId(int reservationId)
    {
        m_reservationId = reservationId;
    }

    public int getRate()
    {
        return m_rate;
    }
    public void setRate(int rate)
    {
        m_rate = rate;
    }

    public boolean getIsGuaranteed()
    {
        return m_isGuaranteed;
    }
    public void setIsGuaranteed(boolean isGuaranteed)
    {
        m_isGuaranteed = isGuaranteed;
    }

    public Calendar getStartDate()
    {
        return m_startDate;
    }
    public void setStartDate(Calendar startDate)
    {
        m_startDate = startDate;
    }

    public Calendar getEndDate()
    {
        return m_endDate;
    }
    public void setEndDate(Calendar endDate)
    {
        m_endDate = endDate;
    }

}

