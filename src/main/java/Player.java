import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Player {
  private String name;
  private int score;
  private int bet;
  private int id;
  private List<String> hand;
  private static ArrayList<Player> players = new ArrayList<Player>();

  public Player(String name) {
    this.name = name;
    this.score = 50;
    this.bet = 5;
    players.add(this);
    this.id = players.size();
  }

  public int getId() {
    return id;
  }

  public static ArrayList<Player> all() {
    return players;
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
