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

  @Test
  public void isSameCard_returnsTrueIfCardsAreSame() {
    Card card = new Card("Hearts", 2);
    Card otherCard = new Card("Hearts", 2);
    assertTrue(card.isSameCard(otherCard));
  }
}
