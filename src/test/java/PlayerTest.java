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

}
