import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import org.sql2o.*;

public class Card {
  private Integer rank;
  private String suit;
  private String link;

  public Card(String suit, Integer rank, String link) {
    this.suit = suit;
    this.rank = rank;
    this.link = link;
  }

  public Integer getRank() {
    return rank;
  }

  public String getSuit() {
    return suit;
  }

  public String getLink() {
    return link;
  }

  public boolean isSameCard(Object otherCard) {
    if(!(otherCard instanceof Card)) {
      return false;
    } else {
      Card newCard = (Card) otherCard;
      return this.getSuit().equals(newCard.getSuit()) &&
             this.getRank().equals(newCard.getRank());
    }
  }
}
