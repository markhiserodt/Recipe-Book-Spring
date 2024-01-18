package recipebook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import recipebook.entity.Recipe;
import recipebook.service.TestService;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    TestService service;

    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value="/stream", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StreamingResponseBody> stream() {
        StreamingResponseBody stream = out -> {
            for (int i = 1; i <= 20; i++) {
                try {
                    Thread.sleep(10);
                    out.write(("Data stream line - " + i + "\n").getBytes());
                } catch (InterruptedException e) {
                    logger.error("Error writing stream", e);
                }
            }
        };
        return new ResponseEntity<>(stream, HttpStatus.OK);
    }

    // Uses HttpUtil (HttpClientConnection manually set up)
    @CrossOrigin
    @GetMapping(value = "/testGet")
    public List<Recipe> testGet() {
        return this.service.getAvailable();
    }

    // Uses
    @CrossOrigin
    @GetMapping(value = "/testGet2")
    public Recipe[] testGet2() {
        return this.service.getRecipes();
    }
}
