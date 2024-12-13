package oncall;

import java.util.LinkedList;
import java.util.Queue;

public class DayOfWeek {
    private final Queue<String> orderedValue;

    public DayOfWeek() {
        this.orderedValue = new LinkedList<>();
        orderedValue.add("월");
        orderedValue.add("화");
        orderedValue.add("수");
        orderedValue.add("목");
        orderedValue.add("금");
        orderedValue.add("토");
        orderedValue.add("일");
    }

    public boolean isContained(String dayOfWeekCandidate) {
        return orderedValue.contains(dayOfWeekCandidate);
    }

    public void orderedBy(String start) {
        while(true) {
            String currentStart = orderedValue.peek();
            if(currentStart.equals(start)) {
                break;
            }
            String newLast = orderedValue.poll();
            orderedValue.add(newLast);
        }
    }

    public String getNow() {
        String poll = orderedValue.poll();
        orderedValue.add(poll);
        return poll;
    }
}
