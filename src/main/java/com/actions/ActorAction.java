package com.highradius.actions;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.highradius.pojo.Actor;
import com.highradius.manager.ActorManager;
import com.highradius.exceptions.CustomException;

public class ActorAction {

    private Actor actor;
    private ActorManager actorManager;
    private List<Actor> actors;
    public ApplicationContext context;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public String getAllActors() {
        try {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
            actorManager = (ActorManager) context.getBean("actorManagerImpl");
            actors = actorManager.getAllActors();
            if (actors != null) {
                return "success";
            }
        } catch (CustomException e) {
            return "error: " + e.getMessage();
        }
        return "error";
    }

    public String addActor() {
    	String message = "error";
    	
        try {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
            actorManager = (ActorManager) context.getBean("actorManagerImpl");
            int result = actorManager.addActor(actor);
            if (result > 0) {
                return "added";
            }
        } catch (CustomException e) {
            return "Error message:  " + e.getMessage();
        }
        return message;
    }

    public String updateActor() {
    	String message = "error";
    	
        try {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
            actorManager = (ActorManager) context.getBean("actorManagerImpl");
            int result = actorManager.updateActor(actor);
            if (result > 0) {
                return "updated";
            }
        } catch (CustomException e) {
            return "Error message: " + e.getMessage();
        }
        return message;
    }

    public String deleteActor() {
    	String message = "error";
    	
        try {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
            actorManager = (ActorManager) context.getBean("actorManagerImpl");
            int result = actorManager.deleteActor(actor);
            if (result > 0) {
                return "deleted";
            }
        } catch (CustomException e) {
            return "Error message: " + e.getMessage();
        }
        return message;
    }
}