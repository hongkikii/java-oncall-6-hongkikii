package oncall;

import java.util.EnumSet;
import java.util.List;

public enum Calendar {
    Jan(1, 31, List.of(1)),
    Feb(2,28, List.of()),
    Mar(3, 31, List.of(1)),
    Apr(4, 30, List.of()),
    May(5, 31, List.of(5)),
    Jun(6, 30, List.of(6)),
    Jul(7, 31, List.of()),
    Aug(8, 31, List.of(15)),
    Sep(9, 30, List.of()),
    Oct(10, 31, List.of(3, 9)),
    Nov(11, 30, List.of()),
    Dec(12, 31, List.of(25));

    private final int numOfMonth;
    private final int lastDay;
    private final List<Integer> holiday;

    Calendar(int numOfMonth, int lastDay, List<Integer> holiday) {
        this.numOfMonth = numOfMonth;
        this.lastDay = lastDay;
        this.holiday = holiday;
    }

    public int getNumOfMonth() {
        return numOfMonth;
    }

    public int getLastDay() {
        return lastDay;
    }

    public List<Integer> getHoliday() {
        return holiday;
    }

    public boolean isHoliday(int day) {
        return getHoliday().contains(day);
    }

    public static Calendar getBy(int numOfMonth) {
        return EnumSet.allOf(Calendar.class).stream()
                .filter(calendar -> calendar.getNumOfMonth() == numOfMonth)
                .findFirst()
                .orElse(null);
    }
}
