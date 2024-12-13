package oncall;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public MonthDay readMonthDay(Day day) {
        MonthDay monthDay = null;
        while(monthDay == null) {
            try {
                System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
                String monthDayCandidate = Console.readLine();
                monthDay = parse(monthDayCandidate, day);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return monthDay;
    }

    private MonthDay parse(String monthDayCandidate, Day day) {
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
            if(!day.isContained(dayCandidate)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }

        return new MonthDay(monthCandidate, dayCandidate);
    }
}
