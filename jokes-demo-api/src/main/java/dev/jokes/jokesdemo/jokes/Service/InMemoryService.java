package dev.jokes.jokesdemo.jokes.Service;

import dev.jokes.jokesdemo.jokes.Model.Joke;
import dev.jokes.jokesdemo.jokes.Repository.InMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryService {

    private final InMemoryRepository repo;

    public InMemoryService(InMemoryRepository repo) {
        this.repo = repo;
    }

    public List<Joke> getJokes() {
        return repo.getJokes();
    }

    public Joke getRandomJoke() {
        List<Joke> jokes = repo.getJokes();
        if (jokes.isEmpty()) {
            return new Joke("There are no jokes");
        }
        int index = (int) (Math.random() * jokes.size());
        return jokes.get(index);
    }

    public Joke addJoke(String jokeContent) {
        return repo.addJoke(jokeContent);
    }
}
