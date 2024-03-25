package domain;

import java.util.Comparator;

public class StartingHoursComparator implements Comparator<Weather> {
    public int compare(Weather o1, Weather o2) {
        return String.valueOf(o1.getStarting_hours()).compareTo(String.valueOf(o2.getStarting_hours()));

    }

}
