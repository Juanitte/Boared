package com.juanite.model.domain.interfaces;

import com.juanite.model.domain.Game;
import com.juanite.model.domain.User;

public interface iUser {

    User create() throws Exception;
    User update(User user) throws Exception;
    void remove() throws Exception;
    boolean addGame(Game game);
    boolean removeGame(Game game);
    boolean addFriend(User user);
    boolean removeFriend(User user);
    boolean addFriendRequest(User user, boolean isSender);
    boolean removeFriendRequest(User user);

}
