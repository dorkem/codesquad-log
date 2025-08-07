import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int PLAYER_COUNT = 2;

        List<Integer> points = Arrays.asList(0, 1, 2, 0, 0, 0, 1);

        DartGame dartGame = new DartGame(PLAYER_COUNT);
        dartGame.play(points);
    }
}
