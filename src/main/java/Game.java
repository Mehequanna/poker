import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import org.sql2o.*;

public class Game {
  private String playerName;
  private String[] suits = {"clubs", "spades", "hearts", "diamonds"};
  private Integer[] ranks = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
  private ArrayList newDeck = new ArrayList();

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
}
