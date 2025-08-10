import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player A = new Player("A");
        Player B = new Player("B");
        final int PEOPLE_COUNT = 2;

        List<Integer> points = Arrays.asList(0, 1, 2, 0, 0, 0, 1, 5, 4, 5, 6, 4, 4, 6, 9, 9, 10, 0, 10, 10, 1);

        DartGame dartGame = new DartGame(A, B, PEOPLE_COUNT);
        dartGame.play(points);
    }
}
