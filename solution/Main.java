import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player a =  new Player("A");
        Player b =  new Player("B");
        List<Integer> list = Arrays.asList(0, 1, 2, 0, 0, 0, 1);

        DartGame dartGame = new DartGame(Arrays.asList(a, b));
        dartGame.play();
    }
}
