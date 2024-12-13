package oncall;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        DayOfWeek dayOfWeek = new DayOfWeek();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        SettingDate settingDate = inputView.readSettingDate(dayOfWeek);
        dayOfWeek.orderedBy(settingDate);

        WorkOrder workOrder = inputView.readWorkOrder();

        WorkTable workTable = new WorkTable(settingDate, workOrder, dayOfWeek);
        outputView.show(workTable);
    }
}
