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
      System.out.println(card.getSuit() + card.getRank());
    }
  }
}
