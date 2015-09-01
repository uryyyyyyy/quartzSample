package com.example.util.spec;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Set;

public interface NormalHourUtil {

    LocalDate calcLastDateOfMonth(Year year, Month month);

    Set<LocalDate> calcDatesByCronPattern(LocalDate from, LocalDate to, Set<Year> years, Set<Month> month, Set<Short> day);

    Set<LocalDate> calcLastDatesOfMonth(LocalDate from, LocalDate to, Set<Year> years, Set<Month> month);

}
