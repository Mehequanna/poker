import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import org.sql2o.*;

public class Game {
  private String playerName;
  private String[] suits = {"clubs", "spades", "hearts", "diamonds"};
  private Integer[] ranks = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
  private ArrayList<Card> newDeck = new ArrayList<Card>();
  private ArrayList<Card> hand = new ArrayList<Card>();

  public Game(String playerName) {
    this.playerName = playerName;
  }

  public ArrayList<Card> getDeck() {
    for (String suit : suits) {
      for(int rank : ranks) {
        Card card = new Card(suit, rank);
        newDeck.add(card);
      }
    }
    return newDeck;
  }

  public ArrayList<Card> getHand() {
    int cardsLeft = 52;

    for (int i = 0; i < 5; i++) {
      Random random = new Random();
      int randomNumber = random.nextInt(cardsLeft) + 1;
      Card chosen = newDeck.get(randomNumber);
      hand.add(chosen);
      newDeck.remove(chosen);
      cardsLeft --;
    }
    return hand;
  }

  // Start of winning conditions.
  public boolean isFlush() {
    String handSuit = hand.get(0).getSuit();

    if (hand.get(1).equals(handSuit) && hand.get(2).equals(handSuit) && hand.get(3).equals(handSuit) && hand.get(4).equals(handSuit) ) {
      return true;
    } else {
      return false;
    }
  }

  
}
