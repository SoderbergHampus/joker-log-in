package dev.jokes.jokesdemo.jokes.Repository;

import dev.jokes.jokesdemo.jokes.Model.Joke;
import org.springframework.data.repository.ListCrudRepository;

public interface JokeRepository extends ListCrudRepository<Joke, Integer> {
}
