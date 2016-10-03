import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import org.sql2o.*;

public class Card {
  private String[] suits = {"clubs", "spades", "hearts", "diamonds"};
  private Integer[] ranks = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
  private Integer rank;
  private String suit;

  public Card(String suit, Integer rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public String[] getSuits() {
    return suits;
  }

  public Integer[] getRanks() {
    return ranks;
  }

  public Integer getRank() {
    return rank;
  }

  public String getSuit() {
    return suit;
  }

  public ArrayList<Card> getDeck() {
    ArrayList newDeck = new ArrayList();

    for (String suit : suits) {
      for(int rank : ranks) {
        Card card = new Card(suit, rank);
        newDeck.add(card);
      }
    }
    return newDeck;
  }

}
