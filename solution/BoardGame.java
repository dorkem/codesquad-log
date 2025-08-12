import java.util.*;
import java.util.stream.Collectors;

public class BoardGame {
    final static int MIN_PLAYER_COUNT = 3;
    final static int MAX_PLAYER_COUNT = 5;
    final static int MAX_CARD_NUMBER = 12;


    private final Map<String, Player> players = new HashMap<>();
    List<Card> floor = new ArrayList<>();
    private boolean started = false;

    public void start(int playerCount){
        if (started) throw new IllegalStateException("이미 시작됨");
        if (playerCount < MIN_PLAYER_COUNT || playerCount > MAX_PLAYER_COUNT) throw new IllegalArgumentException("3~5만 허용");

        for (int i = 0; i < playerCount; i++) {
            String name = String.valueOf((char)('A' + i));
            players.put(name, new Player(name));
        }

        List<Card> deck = new ArrayList<>();
        for (Card.CardType cardType : Card.CardType.values()) {
            for (int number = 1; number <= MAX_CARD_NUMBER; number++) {
                deck.add(new Card(number, cardType));
            }
        }

        if (playerCount == 3) {
            Iterator<Card> it = deck.iterator();
            int remove12 = 0;
            while (it.hasNext()) {
                Card card = it.next();
                if (card.getNumber() == 12) {
                    it.remove();
                    remove12++;
                }
                if (remove12 == 12) {
                    break;
                }
            }
        }

        Collections.shuffle(deck, new Random());

        int perPlayer = switch (playerCount) {
            case 3 -> 8;
            case 4 -> 7;
            case 5 -> 6;
            default -> throw new IllegalStateException("잘못된 인원수 입니다.");
        };

        for (int r = 0; r < perPlayer; r++) {
            for (Player player : players.values()) {
                player.setHand(deck.remove(deck.size()-1));
            }
        }

        for (Player player : players.values()) {
            player.sortHand();
        }

        floor.addAll(deck);
        started = true;

        for (Player player : players.values()) {
            System.out.println(player.getName() + 0 + player.handView());
        }
        System.out.println("TABLE [" + floor.size() + "]: " +
                floor.stream().map(Object::toString).collect(Collectors.joining(",")));
        System.out.println();
    }

    public void turn(String playerName){
        if (!started) throw new IllegalStateException("start 먼저 호출 필요");

        Player me = players.get(playerName);
        if (me == null) throw new IllegalArgumentException("플레이어 없음: " + playerName);
        if (me.getHand().isEmpty()) {
            System.out.println(playerName + " 손패 없음. 스킵");
            return;
        }



    }
}
