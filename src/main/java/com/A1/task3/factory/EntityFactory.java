package com.A1.task3.factory;


import com.A1.task3.entity.Entities;
import com.A1.task3.entity.Entity;
import com.A1.task3.entity.LoginEntity;
import com.A1.task3.entity.PostingEntity;
import com.A1.task3.logger.LoggerProvider;

public class EntityFactory {
    private static EntityFactory entityFactory;

    public static EntityFactory getInstance(){
        if (entityFactory == null){
            entityFactory = new EntityFactory();
        }
        return entityFactory;
    }
    public Entity  createEntity(Entities type){
        Entity en = null;

        switch(type){
            case LOGIN:
                en = new LoginEntity();
                break;
            case POSTING:
                en = new PostingEntity();
                break;
            default:
                LoggerProvider.getLOG().error("Object not specified");
                break;
        }
        return en;
    }
}
