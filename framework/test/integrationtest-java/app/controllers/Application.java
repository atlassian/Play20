package controllers;

import org.codehaus.jackson.JsonNode;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index(String name) {
        Http.Context.current().args.put("name",name);
        String n = (String)Http.Context.current().args.get("name");
        return ok(index.render(n));
    }
    
    public static Result key() {
        return ok("Key=" + Play.application().configuration().getString("key"));
    }

    public static Result getIdenticalJson() {
        JsonNode node = request().body().asJson();
        return ok(node);
    }
  
}
