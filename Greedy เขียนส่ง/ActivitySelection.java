import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Activity {
    String name;
    int start;
    int finish;

    Activity(String name, int start, int finish) {
        this.name = name;
        this.start = start;
        this.finish = finish;
    }
}

public class ActivitySelection {
    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>();

        activities.add(new Activity("A", 1, 4));
        activities.add(new Activity("B", 3, 5));
        activities.add(new Activity("C", 0, 6));
        activities.add(new Activity("D", 5, 7));
        activities.add(new Activity("E", 3, 9));
        activities.add(new Activity("F", 5, 9));
        activities.add(new Activity("G", 6, 10));
        activities.add(new Activity("H", 8, 11));
        activities.add(new Activity("I", 8, 12));
        activities.add(new Activity("J", 12, 14));

        activities.sort(Comparator.comparingInt(a -> a.finish));

        List<Activity> selected = new ArrayList<>();
        int lastFinish = -1;

        for (Activity a : activities) {
            if (a.start >= lastFinish) {
                selected.add(a);
                lastFinish = a.finish;
            }
        }

        System.out.println("Selected Activities:");
        for (Activity a : selected) {
            System.out.println(a.name + " (" + a.start + ", " + a.finish + ")");
        }
        System.out.println("Number of Activities = " + selected.size());
    }
}
