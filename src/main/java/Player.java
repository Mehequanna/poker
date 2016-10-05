import org.sql2o.*;
import java.util.Arrays;
import java.util.List;

public class Player {
  private String name;
  private int score;
  private int bet;
  private List<String> hand;

  public Player(String name) {
    this.name = name;
    this.score = 50;
    this.bet = 5;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public int getBet() {
    return bet;
  }

  public void setBet(int newBet) {
    this.bet = newBet;
  }

  public void setScore(int newScore) {
    this.score = newScore;
  }
}
