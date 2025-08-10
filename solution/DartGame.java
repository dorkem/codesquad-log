import java.util.ArrayList;
import java.util.List;

public class DartGame {
    private Player A;
    private Player B;
    private int peopleCount;
    private DartBoard dartBoard;

    private static final int THROW_COUNT = 3; // 1라운드당 던지는 횟수
    private static final int ROUND_POINT = 1; // 범위를 지정하는 수 1개
    private static final int POINT_BOUND = 3; // 범위는 총 3개
    private static final int TOTAL_SCORE_RANGE = 20;

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
        for (int round = 0; round < totalCount; round += totalCount / roundCount) {
            System.out.println(" ");
            System.out.println("Round" + ((round / (THROW_COUNT * peopleCount + ROUND_POINT)) + 1));
			int AStart = round + ROUND_POINT;
            int BStart = AStart + THROW_COUNT;

            if (round > TOTAL_SCORE_RANGE - 1){
                throw new IllegalArgumentException("21 이상의 점수는 없습니다.");
            }

            List<Integer> AScores = points.subList(AStart, AStart+THROW_COUNT);
            List<Integer> BScores = points.subList(BStart, BStart+THROW_COUNT);

            int centerIndex = points.get(round);
            dartBoard.setPointSpot(centerIndex, POINT_BOUND);
            System.out.println("A 점수 토탈!!");
            A.throwDart(dartBoard, AScores);

            System.out.println("B 점수 토탈!!");
            B.throwDart(dartBoard, BScores);
        }
    }

    private void printResult() {
        int AScore = A.getScores();
        int BScore = B.getScores();

        System.out.println(" ");
        System.out.println("A 점수 합: "+ A.getScores());
        System.out.println("B 점수 합: "+ B.getScores());
        if (AScore == BScore) {
            System.out.println("무승부");
        } else if (AScore > BScore) {
            System.out.println("A승");
        } else {
            System.out.println("B승");
        }
        System.out.println(" ");
    }
}
