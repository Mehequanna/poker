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

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/board", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String playerName = request.queryParams("playerName");
      Player player = new Player(playerName);
      Game game = new Game("Game1");
      model.put("template", "templates/board.vtl");
      model.put("player", player);
      model.put("game", game);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/board", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/board.vtl");
      model.put("player", Player.all().get(0));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
