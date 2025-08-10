import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DartBoard {
    private List<Integer> pointRange;

    private static final List<Integer> SCORES = new ArrayList<>(Arrays.asList(
                    20, 1, 18, 4, 13,
                    6, 10, 15, 2, 17,
                    3, 19, 7, 16, 8,
                    11, 14, 9, 12, 5
    ));


    public void setPointSpot(int pointfirstRange, int pointBound) {
        List<Integer> converted = new ArrayList<>();

        for(int i = 0; i < pointBound; i++){
            converted.add((pointfirstRange + i)%20);
        }

        this.pointRange = converted;

        System.out.println(
            "맞춰야하는 점수: [" + pointRange.get(0) + ", " + pointRange.get(1) + ", " + pointRange.get(2)+"]"
        );
    }

    public int hitScore(List<Integer> scores){
        int total = 0;

        for (int index : scores) {
            if (index < 0 || index >= SCORES.size()) continue;

            int scoreValue = SCORES.get(index);

            if (pointRange.contains(index)) {
                total += scoreValue;
            }
        }
        System.out.println(total);
        return total;
    }
}
