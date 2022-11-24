package dataStructure.greedyAlgorithm.ActivitySelection;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelection {

    public List<Activity> getActivities(List<Activity> activities) {
        activities.sort((a1, a2) -> a1.endTime - a2.endTime);
        Activity lastActivity = activities.get(0);
        List<Activity> activityResults = new ArrayList<>();
        activityResults.add(lastActivity);
        for (int i = 1; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);
            if (currentActivity.startTime > lastActivity.endTime) {
                activityResults.add(currentActivity);
                lastActivity = currentActivity;
            }
        }
        return activityResults;
    }

    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("A1", 0, 6));
        activities.add(new Activity("A2", 3, 4));
        activities.add(new Activity("A3", 1, 2));
        activities.add(new Activity("A4", 5, 8));
        activities.add(new Activity("A5", 5, 7));
        activities.add(new Activity("A6", 8, 9));

        ActivitySelection activitySelection = new ActivitySelection();
        List<Activity> resultActivities = activitySelection.getActivities(activities);
        resultActivities.forEach(activity -> System.out.println(activity.name));
    }
}
