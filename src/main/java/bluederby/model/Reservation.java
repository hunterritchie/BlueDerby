package bluederby;

import java.util.Calendar;

public class Reservation
{
    private int m_reservationId;
    private int m_guestId;
    private int m_rate;
    private boolean m_isGuaranteed;
    private Calendar m_startDate;
    private Calendar m_endDate;
    private BedType m_bedType;

    public Reservation(int guestId, BedType bedType, int rate, boolean isGuaranteed, Calendar startDate, Calendar endDate) 
    {
        m_guestId = guestId;
        m_bedType = bedType;
        m_rate = rate;
        m_isGuaranteed = isGuaranteed;
        m_startDate = startDate;
        m_endDate = endDate;
    }

    public Reservation() {}

    public int getReservationId()
    {
        return m_reservationId;
    }
    public void setReservationId(int reservationId)
    {
        m_reservationId = reservationId;
    }

    public int getGuestId()
    {
        return m_guestId;
    }
    public void setGuestId(int guestId)
    {
        m_guestId = guestId;
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

    public BedType getBedType()
    {
        return m_bedType;
    }
    public void setBedType(BedType bedType)
    {
        m_bedType = bedType;
    }

}

