package oncall;

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
    private final int endDay;
    private final List<Integer> holiday;

    Calendar(int numOfMonth, int endDay, List<Integer> holiday) {
        this.numOfMonth = numOfMonth;
        this.endDay = endDay;
        this.holiday = holiday;
    }

    public int getNumOfMonth() {
        return numOfMonth;
    }

    public int getEndDay() {
        return endDay;
    }

    public List<Integer> getHoliday() {
        return holiday;
    }

    public boolean isHoliday(int day) {
        return getHoliday().contains(day);
    }

    public int getLastDay() {
        return getEndDay();
    }

    public static Calendar getBy(int numOfMonth) {
        if (numOfMonth == 1) {
            return Calendar.Jan;
        }
        if (numOfMonth == 2) {
            return Calendar.Feb;
        }
        if (numOfMonth == 3) {
            return Calendar.Mar;
        }
        if (numOfMonth == 4) {
            return Calendar.Apr;
        }
        if (numOfMonth == 5) {
            return Calendar.May;
        }
        if (numOfMonth == 6) {
            return Calendar.Jun;
        }
        if (numOfMonth == 7) {
            return Calendar.Jul;
        }
        if (numOfMonth == 8) {
            return Calendar.Aug;
        }
        if (numOfMonth == 9) {
            return Calendar.Sep;
        }
        if (numOfMonth == 10) {
            return Calendar.Oct;
        }
        if (numOfMonth == 11) {
            return Calendar.Nov;
        }
        return Calendar.Dec;
    }
}
