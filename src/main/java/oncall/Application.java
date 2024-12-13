package oncall;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DayOfWeek dayOfWeek = new DayOfWeek();
        InputView inputView = new InputView();
        MonthDay monthDay = inputView.readMonthDay(dayOfWeek);
        WorkOrder workOrder = inputView.readWorkOrder();
        dayOfWeek.orderedBy(monthDay.getDay());
        WorkTable workTable = new WorkTable(monthDay, workOrder, dayOfWeek);
        OutputView outputView = new OutputView();
        outputView.show(workTable);
    }
}
