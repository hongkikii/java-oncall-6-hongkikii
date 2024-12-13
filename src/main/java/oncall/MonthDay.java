package oncall;

public class MonthDay {
    private final int month;
    private final String day;

    public MonthDay(int month, String day) {
        this.month = month;
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }
}
