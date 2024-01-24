package hello;

import javax.ws.rs.GET;
import org.json.JSONObject;
import javax.ws.rs.Path;


public class Hello {

    public JSONObject getHello() {
        return new JSONObject().put("hello", "Hello");
    }
}
