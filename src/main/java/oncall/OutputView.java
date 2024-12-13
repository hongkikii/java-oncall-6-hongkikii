package oncall;

import java.util.List;

public class OutputView {
    public void show(WorkTable workTable) {
        List<WorkInfo> workInfos = workTable.getWorkInfos();
        for(WorkInfo workInfo : workInfos) {
            System.out.println(workInfo.getFormatted());
        }
    }
}
