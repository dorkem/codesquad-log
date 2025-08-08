import java.util.List;

public class Player {
    private String name;
    private int scores;

    public Player(String name){
        this.name = name;
    }

    public void throwDart(DartBoard dartBoard, List<Integer> scores){
        dartBoard.hitScore(scores);
    }

    public void
}
