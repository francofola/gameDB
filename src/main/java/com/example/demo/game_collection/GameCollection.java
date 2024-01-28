package com.example.demo.game_collection;

import com.example.demo.collection_item.CollectionItem;
import com.example.demo.user.UserDB;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class GameCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public GameCollection() {
    }

    private String title;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDB user;

    @OneToMany(mappedBy = "collection")
    private Set<CollectionItem> gameList;

    private LocalDate createdDate;

    private Time timeToCompletion;

    public GameCollection(String title, UserDB user) {
        this.title = title;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserDB getUser() {
        return user;
    }

    public void setUser(UserDB user) {
        this.user = user;
    }

    public Set<CollectionItem> getGameList() {
        return gameList;
    }

    public void setGameList(Set<CollectionItem> gameList) {
        this.gameList = gameList;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Time getTimeToCompletion() {
        return timeToCompletion;
    }

    public void setTimeToCompletion(Time timeToCompletion) {
        this.timeToCompletion = timeToCompletion;
    }

    @Override
    public String toString() {
        return "GameCollection{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", user=" + user +
                ", gameList=" + gameList +
                ", createdDate=" + createdDate +
                ", timeToCompletion=" + timeToCompletion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameCollection that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(user, that.user) && Objects.equals(gameList, that.gameList) && Objects.equals(createdDate, that.createdDate) && Objects.equals(timeToCompletion, that.timeToCompletion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, user, gameList, createdDate, timeToCompletion);
    }
}
