package oncall;

import java.util.LinkedList;

public class WorkOrder {
    private final LinkedList<String> weekday;
    private final LinkedList<String> holiday;

    public WorkOrder(LinkedList<String> weekday, LinkedList<String> holiday) {
        this.weekday = weekday;
        this.holiday = holiday;
    }

    public LinkedList<String> getWeekday() {
        return weekday;
    }

    public LinkedList<String> getHoliday() {
        return holiday;
    }
}
