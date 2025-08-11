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

    private String cardNumber;
    private CardType cardType;

    public Card(String cardNumber, CardType cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }
}
