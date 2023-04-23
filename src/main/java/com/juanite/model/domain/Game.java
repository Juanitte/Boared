package com.juanite.model.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Game {

    private String name;
    private String description;
    private Set<Genres> genres;
    private int releaseYear;
    private double price;
    private String logo;
    private Set<String> images;
    private Developer developer;

    public Game() {
        this.name = "";
        this.description = "";
        this.genres = new HashSet<Genres>();
        this.releaseYear = 0;
        this.price = 0;
        this.logo = "";
        this.images = new HashSet<String>();
        this.developer = null;
    }

    public Game(String name, String description, Set<Genres> genres, int releaseYear, double price, String logo, Developer developer) {
        this.name = name;
        this.description = description;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.price = price;
        this.logo = logo;
        this.developer = developer;
    }

    public Game(String name, String description, Set<Genres> genres, int releaseYear, double price, String logo, Set<String> images, Developer developer) {
        this.name = name;
        this.description = description;
        this.genres = genres;
        this.releaseYear = releaseYear;
        this.price = price;
        this.logo = logo;
        this.images = images;
        this.developer = developer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Genres> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genres> genres) {
        this.genres = genres;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
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

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(name, game.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
