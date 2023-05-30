import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class DeckOfCards {
    private ArrayList<Card> deck;

    public DeckOfCards() {
        deck = new ArrayList<>();
    }

    public void fillDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    public Card drawCard() {
        if (deck.isEmpty())
            return null;
        return deck.remove(0);
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.fillDeck();
        deck.shuffle();

        ArrayList<Card> selectedCards = new ArrayList<>();
        selectedCards.add(deck.drawCard());
        selectedCards.add(deck.drawCard());

        System.out.println("Selected cards:");
        for (Card card : selectedCards) {
            System.out.println(card);
        }

        if (selectedCards.get(0).equals(selectedCards.get(1))) {
            System.out.println("The cards match!");
        } else {
            System.out.println("The cards do not match.");
        }
    }
}

enum Suit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES
}

enum Rank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
}

class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Card otherCard = (Card) obj;
        return rank == otherCard.rank && suit == otherCard.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
