package com.example.demo.game;

import com.example.demo.genres.Genre;
import com.example.demo.systems.GameSystem;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ElementCollection(targetClass = GameSystem.class)
    @JoinTable(name = "systemPlatforms", joinColumns = @JoinColumn(name = "gameId"))
    @Column(name = "releasePlatforms")
    @Enumerated(EnumType.STRING)
    private Set<GameSystem> releasePlatforms;

    @ElementCollection(targetClass = Genre.class)
    @JoinTable(name = "genres", joinColumns = @JoinColumn(name = "gameId"))
    @Column(name = "genres")
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    private Time timeToBeat;

    private LocalDate releaseDate;

    private String developer;

    private String title;

    public Game(Set<GameSystem> releasePlatforms, Set<Genre> genres, LocalDate releaseDate, String developer, String title) {
        this.releasePlatforms = releasePlatforms;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.developer = developer;
        this.title = title;
    }

    public Game(Set<GameSystem> releasePlatforms, Set<Genre> genres, Time timeToBeat, LocalDate releaseDate, String developer, String title) {
        this.releasePlatforms = releasePlatforms;
        this.genres = genres;
        this.timeToBeat = timeToBeat;
        this.releaseDate = releaseDate;
        this.developer = developer;
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public Set<GameSystem> getReleasePlatforms() {
        return releasePlatforms;
    }

    public void setReleasePlatforms(Set<GameSystem> releasePlatforms) {
        this.releasePlatforms = releasePlatforms;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Time getTimeToBeat() {
        return timeToBeat;
    }

    public void setTimeToBeat(Time timeToBeat) {
        this.timeToBeat = timeToBeat;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game game)) return false;
        return Objects.equals(id, game.id) && Objects.equals(releasePlatforms, game.releasePlatforms) && Objects.equals(genres, game.genres) && Objects.equals(timeToBeat, game.timeToBeat) && Objects.equals(releaseDate, game.releaseDate) && Objects.equals(developer, game.developer) && Objects.equals(title, game.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, releasePlatforms, genres, timeToBeat, releaseDate, developer, title);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", releasePlatforms=" + releasePlatforms +
                ", genres=" + genres +
                ", timeToBeat=" + timeToBeat +
                ", releaseDate=" + releaseDate +
                ", developer='" + developer + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
