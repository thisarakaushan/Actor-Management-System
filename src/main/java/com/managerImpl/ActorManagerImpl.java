
package com.highradius.managerImpl;

import java.util.List;
import com.highradius.Dao.ActorDao;
import com.highradius.pojo.Actor;
import com.highradius.manager.ActorManager;
import com.highradius.exceptions.CustomException;

public class ActorManagerImpl implements ActorManager {
    ActorDao actorDao;

    public ActorDao getActorDao() {
        return actorDao;
    }

    public void setActorDao(ActorDao actorDao) {
        this.actorDao = actorDao;
    }
    	
    /**
     * The method for getting all actors in the database.
     */
    @Override
    public List<Actor> getAllActors() throws CustomException {
        return actorDao.getAllActors();
    }
    
    /**
     * The method for add a actor to the database.
     */
    @Override
    public int addActor(Actor actor) throws CustomException {
        if (actor == null) {
            throw new CustomException("Actor object is null. Please provide valid data.");
        }
        if (!actorDao.exist(actor)) {
            return actorDao.addActor(actor);
        } else {
            throw new CustomException("Actor with the same name already exists.");
        }
    }
    
    /**
     * The method for update a actor in the database.
     */
    @Override
    public int updateActor(Actor actor) throws CustomException {
        if (actor == null) {
            throw new CustomException("Actor object is null. Actor does not exist for update.");
        }
        if (!actorDao.exist(actor)) {
            return actorDao.updateActor(actor);
        } else {
            throw new CustomException("Please provide valid data.b ");
        }
    }
    
    /**
     * The method for deleting a record from the database.
     */
    @Override
    public int deleteActor(Actor actor) throws CustomException {
        if (actor == null) {
            throw new CustomException("Actor object is null. Actor does not exist for deletion.");
        }
        if (!actorDao.exist(actor)) {
            return actorDao.deleteActor(actor);
        } else {
            throw new CustomException("Please provide valid data.");
        }
    }
}

