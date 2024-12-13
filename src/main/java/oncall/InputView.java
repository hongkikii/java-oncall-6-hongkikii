package oncall;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class InputView {
    public SettingDate readSettingDate(DayOfWeek dayOfWeek) {
        SettingDate settingDate = null;
        while(settingDate == null) {
            try {
                System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
                String settingDateCandidate = Console.readLine();
                settingDate = parse(settingDateCandidate, dayOfWeek);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return settingDate;
    }

    private SettingDate parse(String settingDateCandidate, DayOfWeek dayOfWeek) {
        int monthCandidate;
        String dayOfWeekCandidate;
        String[] split = settingDateCandidate.split(",");
        validateSettingDateSize(split);
        monthCandidate = validateMonth(split[0]);
        dayOfWeekCandidate = validateDayOfWeek(split[1], dayOfWeek);
        return new SettingDate(monthCandidate, dayOfWeekCandidate);
    }

    private String validateDayOfWeek(String dayOfWeekCandidate, DayOfWeek dayOfWeek) {
        if(!dayOfWeek.isContained(dayOfWeekCandidate)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        return dayOfWeekCandidate;
    }

    private int validateMonth(String monthCandidate) {
        try {
            int month = Integer.parseInt(monthCandidate);
            if (month < 1 || month > 12) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
            }
            return month;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void validateSettingDateSize(String[] settingDateCandidate) {
        if(settingDateCandidate.length != 2) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    public WorkOrder readWorkOrder() {
        WorkOrder workOrder = null;
        while(workOrder == null) {
            try {
                LinkedList<String> weekdayOrder = getWeekDayOrder();
                LinkedList<String> holidayOrder = getHolidayOrder();
                workOrder = new WorkOrder(weekdayOrder, holidayOrder);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return workOrder;
    }

    private LinkedList<String> getWeekDayOrder() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String weekdayOrderCandidate = Console.readLine();
        return parse(weekdayOrderCandidate);
    }

    private LinkedList<String> getHolidayOrder() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        String holidayOrderCandidate = Console.readLine();
        return parse(holidayOrderCandidate);
    }

    private LinkedList<String> parse(String orderCandidate) {
        LinkedList<String> result = new LinkedList<>();
        validateForm(orderCandidate);
        String[] split = orderCandidate.split(",");
        validateOrderSize(split);
        for(String nickname : split) {
            validate(nickname, result);
            result.add(nickname);
        }
        return result;
    }

    private void validateForm(String weekdayOrderCandidate) {
        if(weekdayOrderCandidate.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void validateOrderSize(String[] orderCandidates) {
        if(orderCandidates.length < 5 || orderCandidates.length > 35) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }

    private void validate(String nickName, List<String> workOrder) {
        if(!Pattern.matches("^[가-힣]{1,5}$", nickName)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
        if(workOrder.contains(nickName)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        }
    }
}
