import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Player {
    private String name;
    private LinkedList<Card> hand = new LinkedList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Card> getHand() {
        return hand;
    }

    public void setHand(Card card) {
        hand.add(card);
    }

    public void sortHand() {
        hand.sort(Comparator.comparingInt(Card::getNumber));
    }

    public String handView() {
        return hand.stream().map(Object::toString).collect(Collectors.joining(","));
    }
}
