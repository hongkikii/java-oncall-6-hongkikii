package oncall;

public class WorkInfo {
    private final String month;
    private final String day;
    private final String dayOfWeek;
    private final String worker;

    public WorkInfo(String month, String day, String dayOfWeek, String worker) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.worker = worker;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getWorker() {
        return worker;
    }

    public String getFormattedInfo() {
        return month + " " + day + " " + dayOfWeek + " " + worker;
    }
}
