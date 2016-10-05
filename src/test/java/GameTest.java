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
    Game game = new Game("GameOne");
    assertTrue(game instanceof Game);
  }

  @Test
  public void getDeck_returnsEntireDeck() {
    Game game = new Game("GameOne");
    ArrayList<Card> cards = game.getDeck();
    assertEquals(cards.size(), 52);
    cards.clear();
  }

  @Test
  public void getHand_returnsFiveCards() {
    Game game = new Game("GameOne");
    ArrayList<Card> cards = game.getDeck();
    ArrayList<Card> hand = game.getHand();
    assertEquals(hand.size(), 5);
  }

  @Test
  public void getLink_returnsImageLink() {
    Game game = new Game("GameOne");
    ArrayList<Card> cards = game.getDeck();
    ArrayList<Card> hand = game.getHand();
    String imageLink = cards.get(0).getLink();
    assertEquals(imageLink, "../images/1.svg");
  }

  @Test
  public void ifFlush_returnsTrueIfHandIsAFlush() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("GameOne");
    Card cardOne = new Card("Hearts", 2, "../images/image.jpg");
    Card cardTwo = new Card("Hearts", 5, "../images/image.jpg");
    Card cardThree = new Card("Hearts", 10, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 12, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 4, "../images/image.jpg");
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
    Game game = new Game("GameOne");
    Card cardOne = new Card("Hearts", 2, "../images/image.jpg");
    Card cardTwo = new Card("Hearts", 5, "../images/image.jpg");
    Card cardThree = new Card("Hearts", 10, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 12, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 4, "../images/image.jpg");
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
    Game game = new Game("GameOne");
    Card cardOne = new Card("Hearts", 2, "../images/image.jpg");
    Card cardTwo = new Card("Hearts", 5, "../images/image.jpg");
    Card cardThree = new Card("Hearts", 10, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 12, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 4, "../images/image.jpg");
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
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 2, "../images/image.jpg");
    Card cardTwo = new Card("Spades", 12, "../images/image.jpg");
    Card cardThree = new Card("Diamonds", 10, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 12, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 4, "../images/image.jpg");
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
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 2, "../images/image.jpg");
    Card cardTwo = new Card("Hearts", 3, "../images/image.jpg");
    Card cardThree = new Card("Spades", 5, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 6, "../images/image.jpg");
    Card cardFive = new Card("Diamonds", 4, "../images/image.jpg");
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
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 10, "../images/image.jpg");
    Card cardTwo = new Card("Clubs", 12, "../images/image.jpg");
    Card cardThree = new Card("Clubs", 11, "../images/image.jpg");
    Card cardFour = new Card("Clubs", 13, "../images/image.jpg");
    Card cardFive = new Card("Clubs", 14, "../images/image.jpg");
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
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 10, "../images/image.jpg");
    Card cardTwo = new Card("Clubs", 12, "../images/image.jpg");
    Card cardThree = new Card("Clubs", 11, "../images/image.jpg");
    Card cardFour = new Card("Clubs", 13, "../images/image.jpg");
    Card cardFive = new Card("Clubs", 9, "../images/image.jpg");
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
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 12, "../images/image.jpg");
    Card cardTwo = new Card("Spades", 12, "../images/image.jpg");
    Card cardThree = new Card("Diamonds", 12, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 12, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 4, "../images/image.jpg");
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    assertEquals(game.getAllPairsArray().size(), 4);
  }

  @Test
  public void getAllPairsFullHouse_returnsCorrectSizeArray_5() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 12, "../images/image.jpg");
    Card cardTwo = new Card("Spades", 7, "../images/image.jpg");
    Card cardThree = new Card("Diamonds", 7, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 7, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 12, "../images/image.jpg");
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
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 12, "../images/image.jpg");
    Card cardTwo = new Card("Spades", 7, "../images/image.jpg");
    Card cardThree = new Card("Diamonds", 7, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 7, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 9, "../images/image.jpg");
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
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 12, "../images/image.jpg");
    Card cardTwo = new Card("Spades", 7, "../images/image.jpg");
    Card cardThree = new Card("Diamonds", 7, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 5, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 9, "../images/image.jpg");
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
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 12, "../images/image.jpg");
    hand.add(cardOne);
    assertEquals(true, game.isInPairsArray(cardOne, hand));
  }

  @Test
  public void isFacePair_returnsTrueIfPairIsJacksOrGreater() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 12, "../images/image.jpg");
    Card cardTwo = new Card("Spades", 12, "../images/image.jpg");
    Card cardThree = new Card("Diamonds", 7, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 5, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 9, "../images/image.jpg");
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
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 2, "../images/image.jpg");
    Card cardTwo = new Card("Spades", 12, "../images/image.jpg");
    Card cardThree = new Card("Diamonds", 12, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 12, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 4, "../images/image.jpg");
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    assertTrue(game.isThreeOfAKind());
    hand.clear();
  }

  @Test
  public void isFullHouse_correctlyEvaluatesPair_true() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 4, "../images/image.jpg");
    Card cardTwo = new Card("Spades", 12, "../images/image.jpg");
    Card cardThree = new Card("Diamonds", 12, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 12, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 4, "../images/image.jpg");
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    assertTrue(game.isFullHouse());
    hand.clear();
  }

  @Test
  public void isFourOfAKind_correctlyEvaluatesPair_true() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 12, "../images/image.jpg");
    Card cardTwo = new Card("Spades", 12, "../images/image.jpg");
    Card cardThree = new Card("Diamonds", 12, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 12, "../images/image.jpg");
    Card cardFive = new Card("Hearts", 4, "../images/image.jpg");
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    assertTrue(game.isFourOfAKind());
    hand.clear();
  }

  @Test
  public void isTwoPair_correctlyEvaluatesPair_true() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 2, "../images/image.jpg");
    Card cardTwo = new Card("Spades", 2, "../images/image.jpg");
    Card cardThree = new Card("Diamonds", 10, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 10, "../images/image.jpg");
    Card cardFive = new Card("Clubs", 4, "../images/image.jpg");
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    assertTrue(game.isTwoPair());
    hand.clear();
  }

  @Test
  public void updateScore_correctlyUpdatesScore() {
    ArrayList<Card> hand = new ArrayList<Card>();
    Player player = new Player("Blake");
    Game game = new Game("GameOne");
    Card cardOne = new Card("Clubs", 2, "../images/image.jpg");
    Card cardTwo = new Card("Spades", 2, "../images/image.jpg");
    Card cardThree = new Card("Diamonds", 10, "../images/image.jpg");
    Card cardFour = new Card("Hearts", 10, "../images/image.jpg");
    Card cardFive = new Card("Clubs", 4, "../images/image.jpg");
    hand.add(cardOne);
    hand.add(cardTwo);
    hand.add(cardThree);
    hand.add(cardFour);
    hand.add(cardFive);
    game.getAllPairs(hand);
    game.updateScore(player, hand);
    assertEquals(player.getScore(), 60);
  }

  @Test
  public void exchangeCards_correctlyUpdatesHand() {
    Player player = new Player("Blake");
    Game game = new Game("GameOne");
    game.getDeck();
    ArrayList<Card> exchangeList = new ArrayList<Card>();
    game.getHand();
    ArrayList<Card> hand = game.getHandCards();
    Card cardOne = hand.get(0);
    Card cardTwo = hand.get(1);
    Card cardThree = hand.get(2);
    Card cardFour = hand.get(3);
    Card cardFive = hand.get(4);
    System.out.println(cardOne.getRank() + " of " + cardOne.getSuit());
    System.out.println(cardTwo.getRank() + " of " + cardTwo.getSuit());
    System.out.println(cardThree.getRank() + " of " + cardThree.getSuit());
    System.out.println(cardFour.getRank() + " of " + cardFour.getSuit());
    System.out.println(cardFive.getRank() + " of " + cardFive.getSuit());
    exchangeList.add(cardOne);
    exchangeList.add(cardTwo);
    exchangeList.add(cardThree);
    game.exchangeCards(hand, exchangeList);
    System.out.println("____________________________________________________");
    System.out.println(hand.get(0).getRank() + " of " + hand.get(0).getSuit());
    System.out.println(hand.get(1).getRank() + " of " + hand.get(1).getSuit());
    System.out.println(hand.get(2).getRank() + " of " + hand.get(2).getSuit());
    System.out.println(hand.get(3).getRank() + " of " + hand.get(3).getSuit());
    System.out.println(hand.get(4).getRank() + " of " + hand.get(4).getSuit());
    assertEquals(game.getDeckCards().size(), 44);
  }
}
