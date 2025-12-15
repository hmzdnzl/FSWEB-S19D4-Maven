package com.workintech.s19d1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ActorController {
    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actor")
    public List<Actor> allActors() {
        return actorService.findAll();
    }

    @GetMapping("/actor/{id}") 
    public Actor getActorById(@PathVariable long id) {
        return actorService.findById(id);
    }

    @PostMapping("/actor")
    public Actor saveActor(@RequestBody ActorRequest actorRequest) {
        Actor actor = actorRequest.getActor();
        if (actorRequest.getMovies() != null) {
            actor.setMovies(actorRequest.getMovies());
        }
        return actorService.save(actor);
    }

    @PutMapping("/actor/{id}")
    public Actor updateActor(@PathVariable long id, @RequestBody Actor actor) {
        Actor actorUpdated = getActorById(id);
        actorUpdated.setFirstName(actor.getFirstName());
        actorUpdated.setLastName(actor.getLastName());
        actorUpdated.setGender(actor.getGender());
        actorUpdated.setBirthDate(actor.getBirthDate());
    
        actorUpdated.getMovies().clear();
        if (actor.getMovies() != null) {
            actorUpdated.getMovies().addAll(actor.getMovies());
        }
        return actorService.save(actorUpdated);
    }

    @DeleteMapping("/actor/{id}")
    public Actor deleteActor(@PathVariable long id) {
        Actor actor = actorService.findById(id);
        actorService.deleteById(id);
        return actor;
    }

}
