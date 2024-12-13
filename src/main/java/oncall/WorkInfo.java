package oncall;

public record WorkInfo(String month, String day, String dayOfWeek, String worker) {

    public String getFormatted() {
        return month + " " + day + " " + dayOfWeek + " " + worker;
    }
}
