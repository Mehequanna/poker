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

}
