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
    cards.clear();
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
    Card cardOne = new Card("Clubs", 2);
    Card cardTwo = new Card("Spades", 12);
    Card cardThree = new Card("Diamonds", 10);
    Card cardFour = new Card("Hearts", 12);
    Card cardFive = new Card("Hearts", 4);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    ArrayList<Card> allPairs = game.getAllPairsArray();
    assertTrue(game.isPair(allPairs));
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

  @Test
  public void isRoyalFlush_returnsTrueIfHandIsRoyalFlush() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Clubs", 10);
    Card cardTwo = new Card("Clubs", 12);
    Card cardThree = new Card("Clubs", 11);
    Card cardFour = new Card("Clubs", 13);
    Card cardFive = new Card("Clubs", 14);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    assertEquals(true, game.isRoyalFlush(hand));
    hand.clear();
  }

  @Test
  public void isStraightFlush_returnsTrueIfHandIsStraightFlush() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Clubs", 10);
    Card cardTwo = new Card("Clubs", 12);
    Card cardThree = new Card("Clubs", 11);
    Card cardFour = new Card("Clubs", 13);
    Card cardFive = new Card("Clubs", 9);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    assertEquals(true, game.isStraightFlush(hand));
    hand.clear();
  }

  @Test
  public void getAllPairsArray_returnsCorrectSizeArray_4() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Clubs", 12);
    Card cardTwo = new Card("Spades", 12);
    Card cardThree = new Card("Diamonds", 12);
    Card cardFour = new Card("Hearts", 12);
    Card cardFive = new Card("Hearts", 4);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    System.out.println(game.getAllPairsArray().get(0).getSuit());
    System.out.println(game.getAllPairsArray().get(1).getSuit());
    assertEquals(game.getAllPairsArray().size(), 4);
  }

  @Test
  public void getAllPairsFullHouse_returnsCorrectSizeArray_5() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Clubs", 12);
    Card cardTwo = new Card("Spades", 7);
    Card cardThree = new Card("Diamonds", 7);
    Card cardFour = new Card("Hearts", 7);
    Card cardFive = new Card("Hearts", 12);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    assertEquals(game.getAllPairsArray().size(), 5);
  }

  @Test
  public void getAllPairs_returnsCorrectSizeArray_3() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Clubs", 12);
    Card cardTwo = new Card("Spades", 7);
    Card cardThree = new Card("Diamonds", 7);
    Card cardFour = new Card("Hearts", 7);
    Card cardFive = new Card("Hearts", 9);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    assertEquals(game.getAllPairsArray().size(), 3);
  }

  @Test
  public void getAllPairs_returnsCorrectSizeArray_2() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Clubs", 12);
    Card cardTwo = new Card("Spades", 7);
    Card cardThree = new Card("Diamonds", 7);
    Card cardFour = new Card("Hearts", 5);
    Card cardFive = new Card("Hearts", 9);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    assertEquals(game.getAllPairsArray().size(), 2);
  }

  @Test
  public void isInPairsArray_returnsTrueIfArrayContainsCard() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Clubs", 12);
    hand.add(cardOne);
    assertEquals(true, game.isInPairsArray(cardOne, hand));
  }

  @Test
  public void isFacePair_returnsTrueIfPairIsJacksOrGreater() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Clubs", 12);
    Card cardTwo = new Card("Spades", 12);
    Card cardThree = new Card("Diamonds", 7);
    Card cardFour = new Card("Hearts", 5);
    Card cardFive = new Card("Hearts", 9);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    assertEquals(true, game.isFacePair());
  }

  @Test
  public void isThreeOfAKind_correctlyEvaluatesPair_true() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("Blake");
    Card cardOne = new Card("Clubs", 2);
    Card cardTwo = new Card("Spades", 12);
    Card cardThree = new Card("Diamonds", 12);
    Card cardFour = new Card("Hearts", 12);
    Card cardFive = new Card("Hearts", 4);
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    assertTrue(game.isThreeOfAKind());
    hand.clear();
  }
}
