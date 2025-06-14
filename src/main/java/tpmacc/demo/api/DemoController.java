package tpmacc.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tpmacc.demo.config.DemoProperties;

import java.util.Map;

@RestController
public class DemoController {

    private final DemoProperties properties;

    public DemoController(DemoProperties properties) {
        this.properties = properties;
    }

     /*
      * Simple endpoint returning a response generated using a request parameter.
      */
     @GetMapping("/greet")
     public Map<String, String> greet(@RequestParam(value = "name", defaultValue = "World") String name) {
         return Map.of("message", "Hello, %s!".formatted(name));
     }
    /*
     * Simple endpoint returning a canned response.
     */
     @GetMapping("/hello")
     public Map<String, String> hello() {
         return Map.of("message", "Hello, World!");
     }

     /*
      * Simple endpoint returning a response generated using a path variable.
      */
     @GetMapping("/hello/{name}")
     public Map<String, String> hello(@PathVariable(value = "name") String name) {
         return Map.of("message", "Hello, %s!".formatted(name));
     }

    /*
     * Simple endpoint returning a response generated using property value.
     */
    @GetMapping("/welcome")
    public Map<String, String> welcome() {
        return Map.of("message", properties.getGreeting());
    }

}
