import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player A = new Player("A");
        Player B = new Player("B");
        final int PEOPLE_COUNT = 2;

        List<Integer> points = Arrays.asList(0, 1, 2, 0, 0, 0, 1, 0, 1, 2, 0, 0, 0, 2);

        DartGame dartGame = new DartGame(A, B, PEOPLE_COUNT);
        dartGame.play(points);
    }
}
