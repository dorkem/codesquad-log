import java.util.ArrayList;
import java.util.List;

public class DartGame {
    private Player A;
    private Player B;
    private int peopleCount;
    private DartBoard dartBoard;

    private static final int THROW_COUNT = 3;
    private static final int ROUND_POINT = 1;

    public DartGame(Player A, Player B, int peopleCount) {
        this.A = A;
        this.B = B;
        this.peopleCount = peopleCount;
        this.dartBoard = new DartBoard();
    }

    public void play(List<Integer> points){
        int totalCount = points.size();
        int roundCount = calculateRoundCount(totalCount);
        throwDart(points, roundCount, totalCount);

        printResult();
    }

    private int calculateRoundCount(int totalCount) {
        int firstRoundCount = THROW_COUNT * peopleCount + ROUND_POINT;
        int increasePerRound = firstRoundCount;
        int rounds;

        if ((totalCount - firstRoundCount) % increasePerRound == 0) {
            rounds = (totalCount - firstRoundCount) / increasePerRound + 1;
        } else {
            throw new IllegalArgumentException("길이가 맞지 않습니다.");
        }

        return rounds;
    }

    private void throwDart(List<Integer> points, int roundCount, int totalCount) {
        for (int round = 0; round < roundCount; round += totalCount / roundCount) {
            int AStart = round;
            int firstPointSpot = round + THROW_COUNT;
            int BStart = round + THROW_COUNT + 1;

            if (firstPointSpot > 19){
                throw new IllegalArgumentException("21 이상의 점수는 없습니다.");
            }

            List<Integer> AScores = points.subList(AStart, AStart+THROW_COUNT);
            List<Integer> pointRange = new ArrayList<>();
            List<Integer> BScores = points.subList(BStart, BStart+THROW_COUNT);

            for (int i = 0; i < 3; i++) {
                pointRange.add((round+THROW_COUNT + i) % 20);
            }

            dartBoard.setPointSpot(pointRange);
            A.throwDart(dartBoard, AScores);
            B.throwDart(dartBoard, BScores);
        }
    }

    private void printResult() {
        int AScore = A.getScores();
        int BScore = B.getScores();
        System.out.println("A 점수 합: "+ A.getScores());
        System.out.println("B 점수 합: "+ B.getScores());
        if (AScore == BScore) {
            System.out.println("무승부");
        } else if (AScore > BScore) {
            System.out.println("A승");
        } else {
            System.out.println("B승");
        }
    }
}
