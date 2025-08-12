public class Card {

    enum CardType {
        DOG("🐶"), CAT("🐱"), COW("🐮");

        private final String emoji;

        CardType(String emoji) {
            this.emoji = emoji;
        }

        public String getEmoji() {
            return emoji;
        }
    }

    private int number;
    private CardType cardType;

    public Card(int number, CardType cardType) {
        this.number = number;
        this.cardType = cardType;
    }

    public int getNumber() {
        return number;
    }

    public CardType getCardType() {
        return cardType;
    }

    @Override
    public String toString() {
        return cardType.getEmoji() + String.format("%02d", number);
    }
}
