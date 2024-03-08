package dev.jokes.jokesdemo.jokes.Service;

import dev.jokes.jokesdemo.jokes.Model.Joke;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JokeServiceTest {

    @Autowired
    private JokeService service;

    @Test
    void shouldHave1Joke() {
        int expected = 1;
        service.addJoke("Teeeeest");

        List<Joke> jokes = service.getJokes();

        assertEquals(expected, jokes.size());
    }

}