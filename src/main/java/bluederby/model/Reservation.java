package bluederby.model;

import java.util.Calendar;

public class Reservation
{
    private int m_reservationId;
    private int m_guestId;
    private double m_baseRate;
    private double m_calculatedRate;
    private boolean m_isGuaranteed;
    private Calendar m_startDate;
    private Calendar m_endDate;
    private BedType m_bedType;
    private boolean m_isHoliday;
    
    private double m_holidayRateMulitplier = 0.1;
    private Guest m_guest;

    public Reservation(int guestId, BedType bedType, double baseRate, boolean isGuaranteed, Calendar startDate, Calendar endDate, boolean isHoliday) 
    {
        m_guestId = guestId;
        m_bedType = bedType;
        m_baseRate = baseRate;
        m_calculatedRate = baseRate;
        m_isGuaranteed = isGuaranteed;
        m_startDate = startDate;
        m_endDate = endDate;
        m_isHoliday = isHoliday;
    }

    public Reservation() {}

    public Reservation(Guest guest, BedType bedType, int rate, boolean isGuaranteed, Calendar startDate, Calendar endDate) {
    	setGuest(guest);
    	m_bedType = bedType;
    	m_rate = rate;
    	m_isGuaranteed = isGuaranteed;
    	m_startDate = startDate;
    	m_endDate = endDate;
	}

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

    public double getBaseRate()
    {
        return m_baseRate;
    }
    
    public void setCalculatedRate(double calculatedRate)
    {
        m_calculatedRate = calculatedRate;
    }
    public double getCalculatedRate()
    {
        return m_calculatedRate;
    }
    public void setBaseRate(int baseRate)
    {
        m_baseRate = baseRate;
    }

    public boolean getIsGuaranteed()
    {
        return m_isGuaranteed;
    }
    public void setIsGuaranteed(boolean isGuaranteed)
    {
        m_isGuaranteed = isGuaranteed;
    }
    
    public boolean getIsHoliday()
    {
        return m_isHoliday;
    }
    public void setIsHoliday(boolean isHoliday)
    {
        m_isHoliday = isHoliday;
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
    public double getHolidayRateMulitplier()
    {
       return m_holidayRateMulitplier;
    }

	public Guest getGuest() {
		return m_guest;
	}

	public void setGuest(Guest m_guest) {
		this.m_guest = m_guest;
	}

}

