package dev.jokes.jokesdemo.jokes.Service;

import dev.jokes.jokesdemo.jokes.Model.Joke;
import dev.jokes.jokesdemo.jokes.Repository.JokeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeService {

    private final JokeRepository repo;

    public JokeService(JokeRepository repo) {
        this.repo = repo;
    }

    public List<Joke> getJokes() {
        return repo.findAll();
    }

    public Joke getRandomJoke() {
        List<Joke> jokes = repo.findAll();
        if (jokes.isEmpty()) {
            return new Joke("There are no jokes");
        }
        int index = (int) (Math.random() * jokes.size());
        return jokes.get(index);
    }

    public Joke addJoke(String jokeContent) {
        return repo.save(new Joke(jokeContent));
    }
}
