package com.example.demo.collection_item;

import com.example.demo.game.Game;
import com.example.demo.game_collection.GameCollection;
import com.example.demo.systems.GameSystem;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
public class CollectionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate addedDate;
    private Integer score;
    @Enumerated(EnumType.STRING)
    private Status gameStatus;

    private Time timeToBeat;
    private GameSystem platform;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gameCollection_id", referencedColumnName = "id")
    private GameCollection collection;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="game_id", referencedColumnName = "id")
    private Game game;

    public CollectionItem(Status gameStatus, GameSystem platform, GameCollection collection, Game game) {
        this.gameStatus = gameStatus;
        this.platform = platform;
        this.collection = collection;
        this.game = game;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Status getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(Status gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Time getTimeToBeat() {
        return timeToBeat;
    }

    public void setTimeToBeat(Time timeToBeat) {
        this.timeToBeat = timeToBeat;
    }

    public GameSystem getPlatform() {
        return platform;
    }

    public void setPlatform(GameSystem platform) {
        this.platform = platform;
    }

    public GameCollection getCollection() {
        return collection;
    }

    public void setCollection(GameCollection collection) {
        this.collection = collection;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CollectionItem that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(addedDate, that.addedDate) && Objects.equals(score, that.score) && gameStatus == that.gameStatus && Objects.equals(timeToBeat, that.timeToBeat) && Objects.equals(platform, that.platform) && Objects.equals(collection, that.collection) && Objects.equals(game, that.game);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addedDate, score, gameStatus, timeToBeat, platform, collection, game);
    }

    @Override
    public String toString() {
        return "CollectionItem{" +
                "id=" + id +
                ", addedDate=" + addedDate +
                ", score=" + score +
                ", gameStatus=" + gameStatus +
                ", timeToBeat=" + timeToBeat +
                ", platform=" + platform +
                ", collection=" + collection +
                ", game=" + game +
                '}';
    }

    public enum Status{
        BACKLOG,
        RETIRED,
        PLAYING,
        COMPLETED,

    }
}
