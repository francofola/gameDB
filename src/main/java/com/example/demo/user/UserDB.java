package com.example.demo.user;

import com.example.demo.game_collection.GameCollection;
import com.example.demo.systems.GameSystem;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table
public class UserDB {
    public UserDB() {
    }

    public UserDB(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Transient
    private Integer age;
    private LocalDate dob;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private String location;

    @Enumerated(EnumType.STRING)
    private UserGender userGender;

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserGender getUserGender() {
        return userGender;
    }

    public void setUserGender(UserGender userGender) {
        this.userGender = userGender;
    }

    public Set<GameCollection> getGameCollections() {
        return gameCollections;
    }

    public void setGameCollections(Set<GameCollection> gameCollections) {
        this.gameCollections = gameCollections;
    }

    public Set<GameSystem> getPlatformsOfChoice() {
        return platformsOfChoice;
    }

    public void setPlatformsOfChoice(Set<GameSystem> platformsOfChoice) {
        this.platformsOfChoice = platformsOfChoice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @OneToMany(mappedBy = "user")
    private Set<GameCollection> gameCollections;
    @ElementCollection(targetClass = GameSystem.class)
    @JoinTable(name = "platformsOfChoice", joinColumns = @JoinColumn(name = "userId"))
    @Column(name = "platformsOfChoice", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<GameSystem> platformsOfChoice;

    private String username;
    private LocalDate createdDate;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }


    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public enum UserStatus {
        ACTIVE, INACTIVE
    }

    public enum UserGender {
        MALE, FEMALE, NON_BINARY, PREFER_NOT_TO_SAY
    }

    public UserDB(String name, Integer age, LocalDate dob, String email, String location, UserGender userGender, String username) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.email = email;
        this.location = location;
        this.userGender = userGender;
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", userStatus=" + userStatus +
                ", location='" + location + '\'' +
                ", userGender=" + userGender +
                ", gameCollections=" + gameCollections +
                ", platformsOfChoice=" + platformsOfChoice +
                ", username='" + username + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDB userDB)) return false;
        return Objects.equals(id, userDB.id) && Objects.equals(name, userDB.name) && Objects.equals(age, userDB.age) && Objects.equals(dob, userDB.dob) && Objects.equals(email, userDB.email) && userStatus == userDB.userStatus && Objects.equals(location, userDB.location) && userGender == userDB.userGender && Objects.equals(gameCollections, userDB.gameCollections) && Objects.equals(platformsOfChoice, userDB.platformsOfChoice) && Objects.equals(username, userDB.username) && Objects.equals(createdDate, userDB.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, dob, email, userStatus, location, userGender, gameCollections, platformsOfChoice, username, createdDate);
    }
}

