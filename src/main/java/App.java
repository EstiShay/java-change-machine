import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class App {
    public static void main(String[] args) {


        get("/", (request, response) -> {
            Map<String, Object> data = new HashMap<String, Object>();
            return new ModelAndView(data, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/change", (request, response) -> {
            Map<String, Object> data = new HashMap<String, Object>();
            String input = request.queryParams("amount");
            Float cash = Float.parseFloat(input);
            ChangeMachine changeMachine = new ChangeMachine();
            String output = changeMachine.makeChange(cash);
            data.put("output", output);
            return new ModelAndView(data, "change.hbs");

        }, new HandlebarsTemplateEngine());

    }
}
