import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.*;

public class PlayerTest {

  Player player1 = new Player("Blake");
  Player player2 = new Player("Stephen");

  @Test
  public void player_instantiatesCorrectly_true() {
    Player player = player1;
    assertTrue(player instanceof Player);
  }

  @Test
  public void getName_returnsName_true() {
    Player player = player1;
    assertEquals("Blake", player.getName());
  }

  @Test
  public void getScore_returnsScore_true() {
    Player player = player1;
    assertEquals(50, player.getScore());
  }

  @Test
  public void getBet_returnsBet_true() {
    Player player = player1;
    assertEquals(5, player.getBet());
  }

  @Test
  public void setBet_changesBetAmount_true() {
    Player player = player1;
    player.setBet(1);
    assertEquals(player.getBet(), 1);
  }
}
