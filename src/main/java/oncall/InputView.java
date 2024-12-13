package oncall;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class InputView {
    public MonthDay readMonthDay(DayOfWeek dayOfWeek) {
        MonthDay monthDay = null;
        while(monthDay == null) {
            try {
                System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
                String monthDayCandidate = Console.readLine();
                monthDay = parse(monthDayCandidate, dayOfWeek);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return monthDay;
    }

    private MonthDay parse(String monthDayCandidate, DayOfWeek dayOfWeek) {
        int monthCandidate;
        String dayCandidate;
        String[] split = monthDayCandidate.split(",");
        if(split.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        try {
            // 월 검증
            monthCandidate = Integer.parseInt(split[0]);
            if (monthCandidate < 1 || monthCandidate > 12) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }

            // 요일 검증
            dayCandidate = split[1];
            if(!dayOfWeek.isContained(dayCandidate)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }

        return new MonthDay(monthCandidate, dayCandidate);
    }

    public WorkOrder readWorkOrder() {
        WorkOrder workOrder = null;
        while(workOrder == null) {
            try {
                System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
                String weekdayOrderCandidate = Console.readLine();
                LinkedList<String> weekdayOrder = parse(weekdayOrderCandidate);
                System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
                String holidayOrderCandidate = Console.readLine();
                LinkedList<String> holidayOrder  = parse(holidayOrderCandidate);
                workOrder = new WorkOrder(weekdayOrder, holidayOrder);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return workOrder;
    }

    private LinkedList<String> parse(String weekdayOrderCandidate) {
        LinkedList<String> result = new LinkedList<>();
        if(weekdayOrderCandidate.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        String[] split = weekdayOrderCandidate.split(",");
        if(split.length < 5 || split.length > 35) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        for(String nickname : split) {
            if(!Pattern.matches("^[가-힣]{1,5}$", nickname)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
            if(result.contains(nickname)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
            result.add(nickname);
        }
        return result;
    }
}
