import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class CardTest {

  @Test
  public void card_instantiatesCorrectly_true() {
    Card pokerCard = new Card("Hearts", 2);
    assertTrue(pokerCard instanceof Card);
  }

  // @Test
  // public void getSuits_returnsSuits_true() {
  //   Deck pokerDeck = new Deck();
  //   String[] suitSize = pokerDeck.getSuits();
  //   for (String everySuit : suitSize ) {
  //     System.out.println("Contents of suitList = " + everySuit);
  //   }
  //   assertEquals(suitSize[0], "clubs");
  //   assertEquals(suitSize[1], "spades");
  //   assertEquals(suitSize[2], "hearts");
  //   assertEquals(suitSize[3], "diamonds");
  // }
  //
  // @Test
  // public void getRanks_returnsRanks_true(){
  //   //write the test
  // }

  // @Test
  // public void deck_arraySized_true() {
  //   Deck pokerDeck = new Deck();
  //   int deckSize = pokerDeck.getDeck().size();
  //   System.out.println("Size of list = " + deckSize);
  //   assertTrue(deckSize > 50);
  // }

  @Test
  public void getSuit_returnsSuit_true() {
    Card card = new Card("Hearts", 2);
    assertEquals(card.getSuit(), "Hearts");
  }

  @Test
  public void getRank_returnsSuit_true() {
    Card card = new Card("Hearts", 2);
    assertTrue(card.getRank() == 2);
  }

}
