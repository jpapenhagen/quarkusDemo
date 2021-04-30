package de.papenhagen.service;

import javax.inject.Named;
import javax.inject.Singleton;
import java.time.LocalDate;

@Named("holidayService")
@Singleton
public class HolidayService {

    public boolean isFeiertag()    {
        int jahr = LocalDate.now().getYear();

        int a = jahr % 19;
        int b = jahr % 4;
        int c = jahr % 7;
        int monat = 0;

        int m = (8 * (jahr / 100) + 13) / 25 - 2;
        int s = jahr / 100 - jahr / 400 - 2;
        m = (15 + s - m) % 30;
        int n = (6 + s) % 7;

        int d = (m + 19 * a) % 30;

        if (d == 29){
            d = 28;
        } else if (d == 28 && a >= 11){
            d = 27;
        }

        int e = (2 * b + 4 * c + 6 * d + n) % 7;

        int tag = 21 + d + e + 1;

        if (tag > 31)  {
            tag = tag % 31;
            monat = 3;
        } else {
            monat = 2;
        }

        LocalDate gc_ostersonntag = LocalDate.of(jahr, monat, tag);
        LocalDate gc_ostermontag = gc_ostersonntag.plusDays(1);
        LocalDate gc_karfreitag = gc_ostersonntag.minusDays(2);
        LocalDate gc_rosenmontag = gc_ostersonntag.minusDays(48);
        LocalDate gc_christihimmelfahrt = gc_ostersonntag.plusDays(39);
        LocalDate gc_pfinstsonntag = gc_ostersonntag.plusDays(49);
        LocalDate gc_pfinstmontag = gc_ostersonntag.plusDays(50);
        LocalDate gc_frohnleichnahm = gc_ostersonntag.plusDays(60);

        LocalDate gc_wiedervereinigung = LocalDate.of(LocalDate.now().getYear(), 10, 1);
        LocalDate gc_weihnachten_1 = LocalDate.of(LocalDate.now().getYear(), 12, 24);
        LocalDate gc_weihnachten_2 = LocalDate.of(LocalDate.now().getYear(), 12, 25);
        LocalDate gc_weihnachten_3 = LocalDate.of(LocalDate.now().getYear(), 12, 26);
        LocalDate gc_silvester = LocalDate.of(LocalDate.now().getYear(), 12, 31);
        LocalDate gc_neujahr = LocalDate.of(LocalDate.now().getYear(), 1, 1);

        return gc_ostermontag.equals(LocalDate.now())
                || gc_karfreitag.equals(LocalDate.now())
                || gc_rosenmontag.equals(LocalDate.now())
                || gc_christihimmelfahrt.equals(LocalDate.now())
                || gc_pfinstmontag.equals(LocalDate.now())
                || gc_frohnleichnahm.equals(LocalDate.now())
                || gc_weihnachten_1.equals(LocalDate.now())
                || gc_weihnachten_2.equals(LocalDate.now())
                || gc_weihnachten_3.equals(LocalDate.now())
                || gc_silvester.equals(LocalDate.now())
                || gc_neujahr.equals(LocalDate.now())
                || gc_pfinstsonntag.equals(LocalDate.now())
                || gc_ostersonntag.equals(LocalDate.now())
                || gc_wiedervereinigung.equals(LocalDate.now());
    }
}
