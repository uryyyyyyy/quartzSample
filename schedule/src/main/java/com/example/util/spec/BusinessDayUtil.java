package com.example.util.spec;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.Set;

public interface BusinessDayUtil {

    LocalDate calcDateAfter(Set<LocalDate> holidays, LocalDate targetDate, int after);

    LocalDate calcDateBefore(Set<LocalDate> holidays, LocalDate targetDate, int before);

    LocalDate calcNearestDateBefore(Set<LocalDate> holidays, LocalDate targetDate);

    LocalDate calcNearestDateAfter(Set<LocalDate> holidays, LocalDate targetDate);

    LocalDate calcFirstDateOfMonth(Set<LocalDate> holidays, Year year, Month month);

    LocalDate calcLastDateOfMonth(Set<LocalDate> holidays, Year year, Month month);

    Set<LocalDate> calcNearestDatesByCronPatternAfter(Set<LocalDate> holidays, LocalDate from,
                                                      LocalDate to, Set<Year> years, Set<Month> month, Set<Short> day, Set<DayOfWeek> weeks);

    Set<LocalDate> calcNearestDatesByCronPatternBefore(Set<LocalDate> holidays, LocalDate from,
                                                       LocalDate to, Set<Year> years, Set<Month> month, Set<Short> day, Set<DayOfWeek> weeks);

    Set<LocalDateTime> createAllDatesByCronPattern(Set<LocalDate> holidays, LocalDate from, LocalDate to, String cronPattern);

    Set<LocalDate> calcLastDatesOfMonth(Set<LocalDate> holidays, LocalDate from, LocalDate to, Set<Year> years, Set<Month> month);

    Set<LocalDate> calcFirstDatesOfMonth(Set<LocalDate> holidays, LocalDate from, LocalDate to, Set<Year> years, Set<Month> month);

}
