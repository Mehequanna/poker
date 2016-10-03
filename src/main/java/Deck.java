import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import org.sql2o.*;

public class Deck {
  private String[] suits = {"clubs", "spades", "hearts", "diamonds"};
  private String[] ranks = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};


public String[] getSuits() {
  return suits;
}

public String[] getRanks() {
  return ranks;
}

public ArrayList<Deck> getDeck() {
  ArrayList newDeck = new ArrayList();

  for (String suit : suits) {
    for(String rank : ranks) {
      String card = rank + " of " + suit;
      newDeck.add(card);
    }
  }
  return newDeck;
}

}
