import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.*;
import java.sql.Timestamp;
import java.util.Date;

public class LeaderBoardTest {

  LeaderBoard leaderAlpha = new LeaderBoard("Blake", 500);
  LeaderBoard leaderBravo = new LeaderBoard("Stephen", 2500);

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void LeaderBoard_instantiates_true() {
    LeaderBoard testLeader = leaderAlpha;
    assertEquals(true, testLeader instanceof LeaderBoard);
  }

  @Test
  public void getLeaderName_returnsLeaderName_Blake() {
    LeaderBoard testLeader = leaderAlpha;
    assertEquals("Blake", testLeader.getLeaderName());
  }

  @Test
  public void getLeaderScore_returnsLeaderScore_500() {
    LeaderBoard testLeader = leaderAlpha;
    assertEquals(500, testLeader.getLeaderScore());
  }

  // @Test
  // public void getLeaderDate_returnsLeaderDate_OCTB042016() {
  //   LeaderBoard testLeader = leaderAlpha;
  //   System.out.println(testLeader.getDate());
  //   assertEquals("", testLeader.getDate());
  // }

  // @Test
  // public void save_recordsTimeOfCreationInDatabase() {
  //   LeaderBoard testLeader = leaderAlpha;
  //   Timestamp savedLeaderTime = LeaderBoard.find(testLeader.getId()).getTimestamp();
  //   Timestamp rightNow = new Timestamp(new Date().getTime());
  //   assertEquals(rightNow.getDay(), savedLeaderTime.getDay());
  // }

}
