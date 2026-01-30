import java.util.HashMap;
import java.util.List;
import java.util.Map;
​
public class BallotsCounter {
​
    public static String getWinner(final List<String> listOfBallots) {
        Map<String, Integer> votes = new HashMap<>();
        int all_votes = listOfBallots.size();
​
        for (String v : listOfBallots) {
            votes.compute(v, (vote, count) -> count == null ? 1 : count + 1);
        }
        int max = votes.values().stream().max(Integer::compareTo).orElse(-1);
​
        String winner = "";
        for (Map.Entry<String, Integer> e : votes.entrySet()) {
            if (e.getValue().equals(max)) {
                winner = e.getKey();
            }
        }
​
        return max > all_votes / 2 ? winner : null;
    }
}