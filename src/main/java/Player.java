import org.sql2o.*;
import java.util.Arrays;
import java.util.List;

public class Player {
  private String name;
  private int score;
  private List<Player> hand;

  public Player(String name) {
    this.name = name;
    this.score = 50;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }
}
