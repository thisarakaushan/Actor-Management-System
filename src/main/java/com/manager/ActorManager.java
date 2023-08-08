package com.highradius.manager;

import java.util.List;
import com.highradius.pojo.Actor;
import com.highradius.exceptions.CustomException;

public interface ActorManager {
    List<Actor> getAllActors() throws CustomException;

    int addActor(Actor actor) throws CustomException;

    int updateActor(Actor actor) throws CustomException;

    int deleteActor(Actor actor) throws CustomException;
}