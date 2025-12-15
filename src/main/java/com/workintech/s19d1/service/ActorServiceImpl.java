package com.workintech.s19d1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.exceptions.ApiException;
import com.workintech.s19d1.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService{
    @Autowired
    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

  @Override
public Actor findById(long id) {
    return actorRepository.findById(id)
        .orElseThrow(() -> new ApiException("actor is not found with id: " + id, HttpStatus.NOT_FOUND));
}

    @Override
    public Actor save(Actor actor) {
    return actorRepository.save(actor);
    }

    @Override
    public Actor update(long id, Actor actor) {
        Actor foundActor = findById(id);
        if (foundActor == null) {
            return null;
        }
        foundActor.setFirstName(actor.getFirstName());
        foundActor.setLastName(actor.getLastName());
        foundActor.setGender(actor.getGender());
        foundActor.setBirthDate(actor.getBirthDate());
        
        return actorRepository.save(foundActor);
    }

    @Override
    public void deleteById(long id) {
        actorRepository.deleteById(id);
    }
}


