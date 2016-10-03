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
}
