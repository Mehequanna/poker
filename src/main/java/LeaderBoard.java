import org.sql2o.*;
import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class LeaderBoard {
  private String name;
  private int score;
  private int id;
  private Timestamp date;

  public LeaderBoard(String name, int score) {
    this.name = name;
    this.score = score;

   try(Connection con = DB.sql2o.open()) {
     String sql = "INSERT INTO leader_board (name, score, date) VALUES (:name, :score, now());";
     this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("score", this.score)
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

  public Timestamp getTimestamp() {
    return date;
  }

  public int getLeaderScore() {
    LeaderBoard leader = LeaderBoard.find(this.id);
    return leader.getScore();
  }

  public static Timestamp findDate(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT date FROM leader_board WHERE id=:id;";
      return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Timestamp.class);
    }
  }

  public String getDate() {
    Timestamp date = LeaderBoard.findDate(this.id);
    return new SimpleDateFormat("MMMB dd, yyyy").format(date);
  }

  // public String getLeaderDate(int id) {
  //   LeaderBoard leader = LeaderBoard.findDate(this.id);
  //   return leader.getDate();
  // }

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
