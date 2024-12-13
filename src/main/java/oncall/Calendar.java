package oncall;

import java.util.List;

public enum Calendar {
    Jan(1, 31, List.of(1)),
    Feb(1,28, List.of()),
    Mar(1, 31, List.of(1)),
    Apr(1, 30, List.of()),
    May(1, 31, List.of(5)),
    Jun(1, 30, List.of(6)),
    Jul(1, 31, List.of()),
    Aug(1, 31, List.of(15)),
    Sep(1, 30, List.of()),
    Oct(1, 31, List.of(3, 9)),
    Nov(1, 30, List.of()),
    Dec(1, 31, List.of(25));

    private final int startDay;
    private final int endDay;
    private final List<Integer> holiday;

    Calendar(int startDay, int endDay, List<Integer> holiday) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.holiday = holiday;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public List<Integer> getHoliday() {
        return holiday;
    }
}
