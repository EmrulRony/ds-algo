package algoexpert.array.TournamentWinner;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertSame;

public class Program {

    public String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results)
    {
        // Write your code here.
        String bestTeam = "";
        Map<String, Integer> teamPointMap = new HashMap<>();
        Integer maxScore = 0;
        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> compitition = competitions.get(i);
            String home = compitition.get(0);
            String away = compitition.get(1);
            String winner = "";
            if (results.get(i) > 0) {
                winner = updateScoreCard(teamPointMap, home, maxScore);
            } else {
                winner = updateScoreCard(teamPointMap, away, maxScore);
            }
            Integer winningPoint = teamPointMap.get(winner);
            if (winningPoint != null && winningPoint > maxScore) {
                maxScore = winningPoint;
                bestTeam = winner;
            }
        }
        return bestTeam;
    }

    private String updateScoreCard(Map<String, Integer> teamPointMap, String winner, Integer maxScore) {
        String grandWinner = "";
        if (teamPointMap.containsKey(winner)) {
            Integer point = teamPointMap.get(winner) + 3;
            teamPointMap.put(winner, point);
            if (point > maxScore) {
                return winner;
            }
        } else {
            teamPointMap.put(winner, 3);
            if (3 > maxScore) {
                return winner;
            }
        }
        return grandWinner;
    }

    @Test
    public void test() {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        String expected = "Python";
        var actual = new Program().tournamentWinner(competitions, results);
        assertSame(expected, actual);
    }
}
