package algoexpert.TournamentWinner;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Program {

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
}

public class TournamentWinner {
}
