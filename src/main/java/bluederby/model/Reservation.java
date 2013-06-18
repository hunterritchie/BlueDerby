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
    private Guest m_guest;
    private boolean m_isHoliday;
    private double m_holidayRateMultiplier = 0.1;

    public Reservation(int guestId, BedType bedType, double baseRate, boolean isGuaranteed, Calendar startDate, Calendar endDate, boolean isHoliday) 
    {
        m_guestId = guestId;
        m_bedType = bedType;
        m_baseRate = baseRate;
        m_isGuaranteed = isGuaranteed;
        m_startDate = startDate;
        m_endDate = endDate;
        m_isHoliday = isHoliday;
        m_calculatedRate = baseRate;
    }

    public Reservation() {}

    public Reservation(Guest guest, BedType bedType, double baseRate, boolean isGuaranteed, Calendar startDate, Calendar endDate, boolean isHoliday) {
    	setGuest(guest);
    	setGuestId(guest.getGuestId());
    	m_bedType = bedType;
    	m_baseRate = baseRate;
    	m_isGuaranteed = isGuaranteed;
    	m_startDate = startDate;
    	m_endDate = endDate;
        m_calculatedRate = baseRate;
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
    
    public double getCalculatedRate()
    {
    	return m_calculatedRate;
    }

    public void setCalculatedRate(double calculatedRate)
    {
    	m_calculatedRate = calculatedRate;
    }
    
    public void setBaseRate(double baseRate)
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
    public double getHolidayRateMultiplier()
    {
       return m_holidayRateMultiplier;
    }

	public Guest getGuest() {
		return m_guest;
	}

	public void setGuest(Guest m_guest) {
		this.m_guest = m_guest;
	}
	
}

