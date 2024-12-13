package oncall;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DayOfWeek dayOfWeek = new DayOfWeek();
        InputView inputView = new InputView();
        SettingDate settingDate = inputView.readSettingDate(dayOfWeek);
        WorkOrder workOrder = inputView.readWorkOrder();
        dayOfWeek.orderedBy(settingDate);
        WorkTable workTable = new WorkTable(settingDate, workOrder, dayOfWeek);
        OutputView outputView = new OutputView();
        outputView.show(workTable);
    }
}
