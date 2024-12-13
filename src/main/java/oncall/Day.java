package oncall;

import java.util.LinkedList;
import java.util.Queue;

public class Day {
    private final Queue<String> orderedDayInfo;

    public Day() {
        this.orderedDayInfo = new LinkedList<>();
        orderedDayInfo.add("월");
        orderedDayInfo.add("화");
        orderedDayInfo.add("수");
        orderedDayInfo.add("목");
        orderedDayInfo.add("금");
        orderedDayInfo.add("토");
        orderedDayInfo.add("일");
    }

    public boolean isContained(String dayCandidate) {
        return orderedDayInfo.contains(dayCandidate);
    }

    public void orderedBy(String startDay) {
        while(true) {
            String currentStartDay = orderedDayInfo.peek();
            if(currentStartDay.equals(startDay)) {
                break;
            }
            String newLastElement = orderedDayInfo.poll();
            orderedDayInfo.add(newLastElement);
        }
    }

    public String getNowDay() {
        String poll = orderedDayInfo.poll();
        orderedDayInfo.add(poll);
        return poll;
    }

    public boolean isWeekDay() {
        String peek = orderedDayInfo.peek();
        return !(peek.equals("토") || peek.equals("일"));
    }
}
