package dev.jokes.jokesdemo.jokes.Model;

import jakarta.persistence.*;

@Entity
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "joke_id")
    private Integer id;

    @Column
    private String content;

    public Joke() {
    }

    public Joke(String content) {
        this.content = content;
    }

    public Joke(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
