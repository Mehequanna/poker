import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import org.sql2o.*;

public class Card {
  private Integer rank;
  private String suit;

  public Card(String suit, Integer rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public Integer getRank() {
    return rank;
  }

  public String getSuit() {
    return suit;
  }
}