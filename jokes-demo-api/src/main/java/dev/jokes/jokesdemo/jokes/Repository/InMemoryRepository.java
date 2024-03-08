package dev.jokes.jokesdemo.jokes.Repository;

import dev.jokes.jokesdemo.jokes.Model.Joke;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryRepository {

    private final List<Joke> jokes;

    public InMemoryRepository() {
        this.jokes = new ArrayList<>();
    }

    public List<Joke> getJokes() {
        return jokes;
    }

    public Joke addJoke(String jokeContent) {
        int id = jokes.getLast().getId() + 1;
        jokes.add(new Joke(id, jokeContent));
        return jokes.getLast();
    }

}
