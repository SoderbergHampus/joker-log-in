package dev.jokes.jokesdemo.jokes.Repository;

import dev.jokes.jokesdemo.jokes.Model.Joke;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JokesRepository {

    private final List<Joke> jokes;

    public JokesRepository() {
        this.jokes = new ArrayList<>();
        this.jokes.add(new Joke());
    }

    public List<Joke> getJokes() {
        return jokes;
    }

}
