package oncall;

import java.util.List;

public class WorkOrder {
    private final List<String> weekday;
    private final List<String> holiday;

    public WorkOrder(List<String> weekday, List<String> holiday) {
        this.weekday = weekday;
        this.holiday = holiday;
    }

    public List<String> getWeekday() {
        return weekday;
    }

    public List<String> getHoliday() {
        return holiday;
    }
}
