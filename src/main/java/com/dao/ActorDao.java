package com.highradius.Dao;

import java.util.List;
import com.highradius.pojo.Actor;
import com.highradius.exceptions.CustomException;

public interface ActorDao {
    List<Actor> getAllActors() throws CustomException;

    int addActor(Actor actor) throws CustomException;

    int updateActor(Actor actor) throws CustomException;

    int deleteActor(Actor actor) throws CustomException;

    boolean exist(Actor actor) throws CustomException;
}