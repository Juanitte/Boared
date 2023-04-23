package com.juanite.model.domain;

import java.util.Objects;
import java.util.Set;

public abstract class Entity {

    protected String name;
    protected String birthDate;
    protected Set<Game> games;
    protected Countries country;

    public abstract String getName();
    public abstract void setName(String name);
    public abstract String getBirthDate();
    public abstract void setBirthDate(String birthDate);
    public abstract Set<Game> getGames();
    public abstract void setGames(Set<Game> games);
    public abstract Countries getCountry();
    public abstract void setCountry(Countries country);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
