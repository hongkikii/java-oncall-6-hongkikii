package oncall;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Day day = new Day();
        InputView inputView = new InputView();
        MonthDay monthDay = inputView.readMonthDay(day);
    }
}
