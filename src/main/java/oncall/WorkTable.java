package oncall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WorkTable {
    private final List<WorkInfo> workInfos;
    private final MonthDay monthDay;
    private final WorkOrder workOrder;
    private final Day day;

    public WorkTable(MonthDay monthDay, WorkOrder workOrder, Day day) {
        this.monthDay = monthDay;
        this.workOrder = workOrder;
        this.day = day;
        this.workInfos = new ArrayList<>();
        initialize();
    }

    public List<WorkInfo> getWorkInfos() {
        return Collections.unmodifiableList(workInfos);
    }

    private void initialize() {
        // 평일인지 휴일인지 체크
        // (평일/휴일) 맞는 순번 가져오기
        // 첫번째 사람 꺼내기
        // workinfo 마지막 사람과 동일한지 확인
        // 맞으면 새로운 사람 꺼내고, 다시 첫번째에 넣어버리기
        // 꺼내진 사람 등록!

        Calendar calendar = Calendar.getBy(monthDay.getMonth());
        int lastDay = calendar.getLastDay();
        for (int i = 1; i <= lastDay; i++) {
            String dayOfWeek = day.getNowDay();
            LinkedList<String> workers = workOrder.getWeekday();
            if(dayOfWeek.equals("토") || dayOfWeek.equals("일") || calendar.isHoliday(i)) {
                workers = workOrder.getHoliday();
            }
            String candidate = workers.pollFirst();
            if(!workInfos.isEmpty()) {
                if(isSameWithLastWorker(candidate)) {
                    String newCandidate = workers.pollFirst();
                    workers.addFirst(candidate);
                    candidate = newCandidate;
                }
            }
            String formatMonth = monthDay.getMonth() + "월";
            String formatDay = i + "일";
            if (!(dayOfWeek.equals("토") || dayOfWeek.equals("일")) && calendar.isHoliday(i)) {
                dayOfWeek += "(휴일)";
            }
            workInfos.add(new WorkInfo(formatMonth, formatDay, dayOfWeek, candidate));
            workers.addLast(candidate);
        }
    }

    private boolean isSameWithLastWorker(String candidate) {
        WorkInfo workInfo = workInfos.get(workInfos.size() - 1);
        return workInfo.getWorker().equals(candidate);
    }
}
