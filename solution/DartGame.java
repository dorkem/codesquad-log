import java.util.ArrayList;
import java.util.List;

public class DartGame {
    private List<Player> players;

    public DartGame(int playerCount) {
        this.players = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            String name = String.valueOf((char) ('A' + i));
            players.add(new Player(name));
        }
    }

    public void play(List<Integer> points){
        // points.size() % 사람수*2 한 값을 사람수로 나눠보면 될 듯
    }

    // 같은 21개라도 사람이 3명이면 1라운드고, 사람이 2명이면
}
