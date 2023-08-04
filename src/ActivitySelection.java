import java.util.*;

class Activity {
    private int index;
    private int startTime;
    private int finishTime;

    public Activity(int index, int startTime, int finishTime) {
        this.index = index;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public int getIndex() {
        return index;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }
}


public class ActivitySelection {
    public static void main(String[] args) {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] finishTimes = {2, 4, 6, 7, 9, 9};

        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < startTimes.length; i++) {
            activities.add(new Activity(i,startTimes[i], finishTimes[i]));
        }

        List<Activity> selectedActivities = selectActivities(activities);

        System.out.println("Maximum number of activities that can be performed: " + selectedActivities.size());
        System.out.println("Selected Activities: ");
        for (Activity activity : selectedActivities) {
            System.out.print(activity.getIndex()+" ");
        }
    }

    public static List<Activity> selectActivities(List<Activity> activities) {
        List<Activity> selectedActivities = new ArrayList<>();

        // Sort activities based on finish times
        Collections.sort(activities, Comparator.comparingInt(a -> a.getFinishTime()));

        Activity previousActivity = null;
        for (Activity currentActivity : activities) {
            if (previousActivity == null || currentActivity.getStartTime() >= previousActivity.getFinishTime()) {
                selectedActivities.add(currentActivity);
                previousActivity = currentActivity;
            }
        }

        return selectedActivities;
    }
}
