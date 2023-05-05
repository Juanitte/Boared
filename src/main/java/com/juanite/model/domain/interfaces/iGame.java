package com.juanite.model.domain.interfaces;

import com.juanite.model.domain.Game;
import com.juanite.model.domain.Tags;
import com.juanite.model.domain.User;

public interface iGame {

    Game create() throws Exception;
    Game update(Game game) throws Exception;
    void remove() throws Exception;
    boolean addTag(Tags tag);
    boolean removeTag(Tags tag);
    boolean addImage(String image);
    boolean removeImage(String image);
    boolean addPlayer(User user);
    boolean removePlayer(User user);

}
