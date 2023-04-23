package com.juanite.model.domain;

import java.util.HashSet;
import java.util.Set;

public class Developer extends Entity{
    private String description;
    private String logo;

    public Developer() {
        this.name = "";
        this.description = "";
        this.country = null;
        this.birthDate = "";
        this.logo = "";
        this.games = new HashSet<Game>();
    }
    public Developer(String name, String description, Countries country , String birthdate, String logo) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.birthDate = birthdate;
        this.logo = logo;
        this.games = new HashSet<Game>();
    }
    public Developer(String name, String description, Countries country , String birthdate, String logo, HashSet<Game> games) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.birthDate = birthdate;
        this.logo = logo;
        this.games = games;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public Set<Game> getGames() {
        return this.games;
    }

    @Override
    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Override
    public Countries getCountry() {
        return this.country;
    }

    @Override
    public void setCountry(Countries country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
