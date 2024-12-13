package oncall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WorkTable {
    private final List<WorkInfo> value;
    private final SettingDate settingDate;
    private final WorkOrder workOrder;
    private final DayOfWeek dayOfWeek;

    public WorkTable(SettingDate settingDate, WorkOrder workOrder, DayOfWeek dayOfWeek) {
        this.settingDate = settingDate;
        this.workOrder = workOrder;
        this.dayOfWeek = dayOfWeek;
        this.value = new ArrayList<>();
        initialize();
    }

    public List<WorkInfo> getValue() {
        return Collections.unmodifiableList(value);
    }

    private void initialize() {
        Calendar calendarOfMonth = Calendar.getBy(settingDate.month());
        int lastDay = calendarOfMonth.getLastDay();
        for (int currentDay = 1; currentDay <= lastDay; currentDay++) {
            String nowDayOfWeek = dayOfWeek.getNow();
            LinkedList<String> workers = getWorkerOrder(nowDayOfWeek, currentDay, calendarOfMonth);
            String workerCandidate = workers.pollFirst();
            if(!value.isEmpty() && isSameWithLastWorker(workerCandidate)) {
                String newCandidate = workers.pollFirst();
                workers.addFirst(workerCandidate);
                workerCandidate = newCandidate;
            }
            value.add(getWorkInfoBy(currentDay, nowDayOfWeek, workerCandidate, calendarOfMonth));
            workers.addLast(workerCandidate);
        }
    }

    private LinkedList<String> getWorkerOrder(String nowDayOfWeek, int currentDay, Calendar calendarOfMonth) {
        if(dayOfWeek.isHoliday(nowDayOfWeek) || calendarOfMonth.isHoliday(currentDay)) {
            return workOrder.holiday();
        }
        return workOrder.weekday();
    }

    private boolean isSameWithLastWorker(String candidate) {
        WorkInfo workInfo = value.get(value.size() - 1);
        return workInfo.worker().equals(candidate);
    }

    private WorkInfo getWorkInfoBy(int currentDay, String nowDayOfWeek, String workerCandidate, Calendar calendarOfMonth) {
        String formatMonth = settingDate.month() + "월";
        String formatDay = currentDay + "일";
        if (!dayOfWeek.isHoliday(nowDayOfWeek) && calendarOfMonth.isHoliday(currentDay)) {
            nowDayOfWeek += "(휴일)";
        }
        return new WorkInfo(formatMonth, formatDay, nowDayOfWeek, workerCandidate);
    }
}
