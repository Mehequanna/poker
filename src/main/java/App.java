import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    Game game = new Game("Game1");


    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/board", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String playerName = request.queryParams("playerName");
      Player player = new Player(playerName);
      model.put("template", "templates/board.vtl");
      model.put("player", player);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/board", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/board.vtl");
      model.put("player", Player.all().get(0));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/board/bet", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int playerBet = Integer.parseInt(request.queryParams("playerBet"));
      Player player = Player.all().get(0);
      player.setBet(playerBet);
      model.put("template", "templates/board.vtl");
      model.put("player", player);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/board/deal", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Game newGame = game;
      newGame.getDeckCards().clear();
      newGame.getHandCards().clear();
      newGame.getAllPairsArray().clear();
      newGame.getDeck();
      newGame.getHand();
      model.put("game", newGame);
      model.put("player", Player.all().get(0));
      model.put("template", "templates/play.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/board/exchange" , (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Game newGame = game;
      ArrayList<Card> exchangeList = new ArrayList<Card>();
      String[] cardsToExchange = request.queryParamsValues("checkbox");
      if (cardsToExchange.length > 0) {
        for (int i = 0; i < cardsToExchange.length; i++) {
          exchangeList.add(newGame.getHandCards().get(Integer.parseInt(cardsToExchange[i])));
        }
      }
      newGame.exchangeCards(newGame.getHandCards(), exchangeList);
      model.put("game", newGame);
      model.put("player", Player.all().get(0));
      model.put("template", "templates/play.vtl");
      response.redirect("/board/results");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/board/results" , (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Game newGame = game;
      Player player = Player.all().get(0);
      int bet = player.getBet();
      int oldScore = player.getScore();
      newGame.getAllPairs(newGame.getHandCards());
      newGame.updateScore(player, newGame.getHandCards());
      System.out.println("1:" + newGame.getHandCards().get(0).getRank() +
      " 2:" + newGame.getHandCards().get(1).getRank() +
      " 3:" + newGame.getHandCards().get(2).getRank() +
      " 4:" + newGame.getHandCards().get(3).getRank() +
      " 5:" + newGame.getHandCards().get(4).getRank() );
      int newScore = player.getScore();
      System.out.println("Old Score:" +oldScore + ", New Score" + newScore + ", Bet:" + bet);
      model.put("bet", bet);
      model.put("oldScore", oldScore);
      model.put("newScore", newScore);
      model.put("game", newGame);
      model.put("player", player);
      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
