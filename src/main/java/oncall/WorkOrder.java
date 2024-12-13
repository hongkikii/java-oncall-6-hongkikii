package oncall;

import java.util.LinkedList;

public record WorkOrder(LinkedList<String> weekday, LinkedList<String> holiday) {
}
