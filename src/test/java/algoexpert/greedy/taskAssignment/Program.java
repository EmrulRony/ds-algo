package algoexpert.greedy.taskAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Program {

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> durationIndicesMap = getDurationToIndices(tasks);
        Collections.sort(tasks);
        for (int i = 0; i < k; i++) {
            Integer minDuration = tasks.get(i);
            Integer maxDuration = tasks.get(tasks.size() - i - 1);
            ArrayList<Integer> taskPair = new ArrayList<>();
            ArrayList<Integer> minDurationIndices = durationIndicesMap.get(minDuration);
            Integer minDurationIdx = minDurationIndices.remove(minDurationIndices.size() - 1);
            ArrayList<Integer> maxDurationIndices = durationIndicesMap.get(maxDuration);
            Integer maxDurationIdx = maxDurationIndices.remove(maxDurationIndices.size() - 1);
            taskPair.add(minDurationIdx);
            taskPair.add(maxDurationIdx);
            result.add(taskPair);
        }
        return result;
    }

    private Map<Integer, ArrayList<Integer>> getDurationToIndices(ArrayList<Integer> tasks) {
        Map<Integer, ArrayList<Integer>> durationIndicesMap = new HashMap<>();
        for (int idx = 0; idx < tasks.size(); idx++) {
            Integer duration = tasks.get(idx);
            if (durationIndicesMap.containsKey(duration)) {
                durationIndicesMap.get(duration).add(idx);
            } else {
                ArrayList<Integer> indices = new ArrayList<>();
                indices.add(idx);
                durationIndicesMap.put(duration, indices);
            }
        }
        return durationIndicesMap;
    }
}

