package hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    private CasClient casClient;

    @Autowired
    public GreetingController(CasClient casClient) {
        this.casClient = casClient;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        String sessionData = casClient.putSessionData(name.getBytes());
        return new Greeting(counter.incrementAndGet(), String.format(template, sessionData));
    }
}
