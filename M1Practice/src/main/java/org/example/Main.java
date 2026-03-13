package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.now().plusYears(1);

        Period period = Period.between(localDate , localDate1);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());

        List<LocalDate> localDateList = new ArrayList<>();
        localDateList.add(localDate);
        localDateList.add(localDate1);

        System.out.println(localDateList);

        Collections.sort(localDateList);

        System.out.println(localDateList);


        Collections.sort(localDateList , Collections.reverseOrder());
        System.out.println(localDateList);

        System.out.println(ChronoUnit.DAYS.between(localDate , localDate1));

        }
    }