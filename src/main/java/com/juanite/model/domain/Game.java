package com.juanite.model.domain;

import com.juanite.model.domain.interfaces.iGame;
import com.juanite.model.DAO.GameDAO;
import com.juanite.util.AppData;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.sql.Date;
import java.util.*;

public class Game implements iGame, Observable {

    private String title;
    private String description;
    private Set<Tags> tags;
    private Date releaseDate;
    private double price;
    private String logo;
    private double score;
    private List<String> images;
    private Developer developer;
    private Set<User> players;

    public Game() {
        this("", "", new HashSet<Tags>(), null, 0, "", 0, new ArrayList<String>(), null, new HashSet<User>());
    }

    public Game(String title, String description, Set<Tags> tags, Date releaseDate, double price, String logo, List<String> images, Developer developer) {
        this(title, description, tags, releaseDate, price, logo, 0, images, developer, new HashSet<User>());
    }

    public Game(String title, String description, Set<Tags> tags, Date releaseDate, double price, String logo, double score, List<String> images, Developer developer, Set<User> players) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.releaseDate = releaseDate;
        this.price = price;
        this.logo = logo;
        this.score = score;
        this.images = images;
        this.developer = developer;
        this.players = players;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Tags> getTags() {
        return tags;
    }

    public void setTags(Set<Tags> tags) {
        this.tags = tags;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Set<User> getPlayers() {
        return players;
    }

    public void setPlayers(Set<User> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(title, game.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public Game create() throws Exception {
        if (this.developer != null) {
            this.developer.getGames().add(this);
        }
        try (GameDAO gdao = new GameDAO()) {
            gdao.save(this);
        }

        return this;
    }

    @Override
    public Game update(Game game) throws Exception {
        try (GameDAO gdao = new GameDAO()) {
            if(gdao.find(game.getTitle()) != null){
                gdao.save(game);
            }else{
                gdao.save(game, this.getTitle());
            }
        }

        return game;
    }

    @Override
    public void remove() throws Exception {
        try (GameDAO gdao = new GameDAO()) {
            gdao.delete(this);
            AppData.setGame(null);
        }
    }

    @Override
    public boolean addTag(Tags tag) {
        return this.tags.add(tag);
    }

    @Override
    public boolean removeTag(Tags tag) {
        return this.tags.remove(tag);
    }

    @Override
    public boolean addImage(String image) {
        if(!this.images.contains(image)) {
            return this.images.add(image);
        }
        return false;
    }

    @Override
    public boolean removeImage(String image) {
        return this.images.remove(image);
    }

    @Override
    public boolean addPlayer(User user) {
        return this.players.add(user);
    }

    @Override
    public boolean removePlayer(User user) {
        return this.players.remove(user);
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }
}