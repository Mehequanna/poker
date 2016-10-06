import org.sql2o.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class LeaderBoard {
  private String name;
  private int score;
  private int id;
  private Timestamp date;

  public LeaderBoard(String name, int score, Timestamp date) {
    this.name = name;
    this.score = score;
    this.date = date;

   try(Connection con = DB.sql2o.open()) {
     String sql = "INSERT INTO leader_board (name, score, date) VALUES (:name, :score, :date);";
     this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("score", this.score)
      .addParameter("date", this.date)
      .executeUpdate()
      .getKey();
   }
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return name;
  }

  public String getLeaderName() {
    LeaderBoard leader = LeaderBoard.find(this.id);
    return leader.getName();
  }

  public int getScore() {
    return score;
  }

  public int getLeaderScore() {
    LeaderBoard leader = LeaderBoard.find(this.id);
    return leader.getScore();
  }

  public String getDate() {
    return new SimpleDateFormat("MMMM dd, yyyy").format(this.date);
  }

  public Timestamp getLeaderDate() {
    LeaderBoard leader = LeaderBoard.find(this.id);
    return leader.getDate();
  }

  public static LeaderBoard find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM leader_board WHERE id=:id;";
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(LeaderBoard.class);
    }
  }

  public static List<LeaderBoard> allSortedbyScore() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM leader_board ORDER BY score DESC;";
      return con.createQuery(sql)
      .executeAndFetch(LeaderBoard.class);
    }
  }


}
