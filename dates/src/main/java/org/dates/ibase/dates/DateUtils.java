package org.dates.ibase.dates;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * The common utilities for java.util.Date processing
 * 
 * @author yunjiez001
 *
 */
public class DateUtils
{
  /**
   * Get the adjusted date
   *
   * @param date
   *          - the date to be moved
   * @param days
   *          - if positive, move date days forward, negative move date backward
   * @return
   */
  public static Date getDateAdjusted(final Date date, final int days)
  {
    final Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, days);

    return calendar.getTime();
  }

  /**
   * Get the adjusted date and reset the time (Hour, Minute, Second)
   *
   * @param date
   *          - the date to be moved
   * @param days
   *          - if positive, move date days forward, negative move date backward
   * @param hour
   * @param minutes
   * @param seconds
   * @return
   */
  public static Date getDateAdjusted(final Date date, final int days,
      final int hour, final int minutes, final int seconds)
  {
    final Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, days);

    calendar.set(Calendar.HOUR, hour);
    calendar.set(Calendar.MINUTE, minutes);
    calendar.set(Calendar.SECOND, seconds);

    return calendar.getTime();
  }

  public static void main(final String[] args) throws ParseException
  {
    final Date curr = new Date();
    System.out.println("curr date: " + curr);

    final Date oneDayBefore = getDateAdjusted(curr, -1);
    System.out.println("one day before: " + oneDayBefore);

    final Date tenAM_OneDayBefore = getDateAdjusted(curr, -1, 10, 0, 0);
    System.out.println("10am one day before: " + tenAM_OneDayBefore);
  }
}
