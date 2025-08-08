import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DartBoard {
    private List<Integer> pointRange;
    private List<Integer> scores;

    private static final List<Integer> SCORES = new ArrayList<>(Arrays.asList(
                    20, 1, 18, 4, 13,
                    6, 10, 15, 2, 17,
                    3, 19, 7, 16, 8,
                    11, 14, 9, 12, 5
    ));


    public void setPointSpot(List<Integer> pointRange) {
        this.pointRange = pointRange;
    }

    public void hitScore(List<Integer> scores) {
        this.scores = scores;
        // 3번 뭔가 호출되서 3번더해져야함
    }

    public int calculateScore(){
        int total = 0;

        for (int index : scores) {
            if (index < 0 || index >= SCORES.size()) continue;

            int scoreValue = SCORES.get(index);

            if (pointRange.contains(index)) {
                total += scoreValue;
            }
        }

        return total;
    }
}
