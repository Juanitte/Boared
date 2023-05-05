package com.juanite.model.domain.interfaces;

import com.juanite.model.domain.Developer;
import com.juanite.model.domain.Game;

public interface iDeveloper {

    Developer create() throws Exception;
    Developer update(Developer developer) throws Exception;
    void remove() throws Exception;
    boolean addGame(Game game);
    boolean removeGame(Game game);
}
