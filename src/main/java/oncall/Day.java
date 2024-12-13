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
}
