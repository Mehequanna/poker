import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class GameTest {

  @Test
  public void game_instantiates() {
    Game game = new Game("Blake");
    assertTrue(game instanceof Game);
  }

  @Test
  public void getDeck_returnsEntireDeck() {
    Game game = new Game("Blake");
    ArrayList<Card> cards = game.getDeck();
    assertEquals(cards.size(), 52);
    cards.clear();
  }

  @Test
  public void getHand_returnsFiveCards() {
    Game game = new Game("Blake");
    ArrayList<Card> cards = game.getDeck();
    ArrayList<Card> hand = game.getHand();
    assertEquals(hand.size(), 5);
    for (Card card : hand) {
      System.out.println(card.getRank() + "of " + card.getSuit());
    }
  }

  @Test
  public void ifFlush_returnsTrueIfHandIsAFlush() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Hearts", 2);
    Card cardTwo = new Card("Hearts", 5);
    Card cardThree = new Card("Hearts", 10);
    Card cardFour = new Card("Hearts", 12);
    Card cardFive = new Card("Hearts", 4);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    assertEquals(true, game.isFlush(hand));
    hand.clear();
  }

  @Test
  public void getHighCard_returnsHighestCard() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Hearts", 2);
    Card cardTwo = new Card("Hearts", 5);
    Card cardThree = new Card("Hearts", 10);
    Card cardFour = new Card("Hearts", 12);
    Card cardFive = new Card("Hearts", 4);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    assertEquals(game.getHighCard(hand), cardFour);
    hand.clear();
  }

  @Test
  public void getLowCard_returnsLowestCard() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Hearts", 2);
    Card cardTwo = new Card("Hearts", 5);
    Card cardThree = new Card("Hearts", 10);
    Card cardFour = new Card("Hearts", 12);
    Card cardFive = new Card("Hearts", 4);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    assertEquals(game.getLowCard(hand), cardOne);
    hand.clear();
  }

  @Test
  public void isPair_correctlyEvaluatesPair_true() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("clubs", 2);
    Card cardTwo = new Card("spades", 12);
    Card cardThree = new Card("diamonds", 10);
    Card cardFour = new Card("Hearts", 12);
    Card cardFive = new Card("Hearts", 4);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    assertTrue(game.isPair(hand));
    hand.clear();
  }

  @Test
  public void isStraight_returnsTrueIsHandIsAStraight() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Clubs", 2);
    Card cardTwo = new Card("Hearts", 3);
    Card cardThree = new Card("Spades", 5);
    Card cardFour = new Card("Hearts", 6);
    Card cardFive = new Card("Diamonds", 4);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    assertEquals(true, game.isStraight(hand));
    hand.clear();
  }
}
