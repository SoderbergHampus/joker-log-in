package dev.jokes.jokesdemo.jokes.Controller;

import dev.jokes.jokesdemo.jokes.Model.Joke;
import dev.jokes.jokesdemo.jokes.Model.JokeListDTO;
import dev.jokes.jokesdemo.jokes.Service.InMemoryService;
//import dev.jokes.jokesdemo.jokes.Service.JokeService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/jokes")
@CrossOrigin//(origins = "http://localhost:5173")
public class JokeController {
    //private final JokeService service;
    private final InMemoryService service;

//    public JokeController(JokeService service) {
//        this.service = service;
//    }

    private JokeController(InMemoryService service) {
        this.service = service;
    }

    @GetMapping("/public")
    public ResponseEntity<JokeListDTO> listAllJokes() {
        List<Joke> joke = service.getJokes();

        JokeListDTO jokeListDTO = new JokeListDTO(joke);
        return ResponseEntity.ok(jokeListDTO);
    }

    @GetMapping("/public/random")
    public ResponseEntity<Joke> getRandomJoke() {
        Joke joke = service.getRandomJoke();
        return ResponseEntity.ok(joke);
    }

    @PostMapping("/secure/addJoke")
    public ResponseEntity<Joke> addJoke(RequestEntity<String> request) {
        String jokeContent = request.getBody();
        Joke joke = service.addJoke(jokeContent);

        return ResponseEntity.accepted().body(joke);
    }
}
