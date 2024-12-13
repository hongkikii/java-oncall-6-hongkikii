package oncall;

public class OutputView {
    public void show(WorkTable workTable) {
        for(WorkInfo workInfo : workTable.getValue()) {
            System.out.println(workInfo.getFormatted());
        }
    }
}
