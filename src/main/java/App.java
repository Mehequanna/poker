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

    post("/board/deal", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Game newGame = game;
      newGame.getDeckCards().clear();
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
      System.out.println(newGame.getDeckCards().size());
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
      int newScore = newGame.updateScore(player, newGame.getHandCards());
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
