public class Main {
    public static void main(String[] args) {
        BoardGame game = new BoardGame();
        game.start(3);
        game.turn("A");
        game.turn("B");
        game.turn("C");
    }
}
