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

  public Card getHighCard(ArrayList<Card> hand) {
    int highest = hand.get(0).getRank();
    Card highestCard = hand.get(0);

    for(int i=1; i<hand.size(); i++) {
      if(hand.get(i).getRank() > highest) {
        highest = hand.get(i).getRank();
        highestCard = hand.get(i);
      }
    } return highestCard;
  }

  public Card getLowCard(ArrayList<Card> hand) {
    int lowest = hand.get(0).getRank();
    Card lowestCard = hand.get(0);

    for(int i=1; i<hand.size(); i++) {
      if(hand.get(i).getRank() < lowest) {
        lowest = hand.get(i).getRank();
        lowestCard = hand.get(i);
      }
    } return lowestCard;
  }

  // Start of winning conditions.
  public boolean isFlush(ArrayList<Card> hand) {
    String handSuit = hand.get(0).getSuit();

    if (hand.get(1).getSuit().equals(handSuit) && hand.get(2).getSuit().equals(handSuit) && hand.get(3).getSuit().equals(handSuit) && hand.get(4).getSuit().equals(handSuit) ) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isPair() {
    String handSuit0 = hand.get(0).getSuit();
    String handSuit1 = hand.get(1).getSuit();
    String handSuit2 = hand.get(2).getSuit();
    String handSuit3 = hand.get(3).getSuit();
    String handSuit4 = hand.get(4).getSuit();

    Integer cardRank0 = hand.get(0).getRank();
    Integer cardRank1 = hand.get(1).getRank();
    Integer cardRank2 = hand.get(2).getRank();
    Integer cardRank3 = hand.get(3).getRank();
    Integer cardRank4 = hand.get(4).getRank();

    for (int i = 0; i < 5; i++ ) {
      if ( (cardRank0 == hand.get(i).getRank()) && (!(handSuit0.equals(hand.get(i).getSuit()))) ) {
        return true;
      } else if ( (cardRank1 == hand.get(i).getRank()) && (!(handSuit1.equals(hand.get(i).getSuit()))) ) {
        return true;
      } else if ( (cardRank2 == hand.get(i).getRank()) && (!(handSuit2.equals(hand.get(i).getSuit()))) ) {
        return true;
      } else if ( (cardRank3 == hand.get(i).getRank()) && (!(handSuit3.equals(hand.get(i).getSuit()))) ) {
        return true;
      }
    }
    return false;
  }

  // public boolean isStraight(ArrayList<Card> hand) {
  //   if(!(hand.isPair())) {
  //     if()
  //   }
  // }


}
