package com.workintech.s19d1.service;

import java.util.List;

import com.workintech.s19d1.entity.Actor;

public interface ActorService {
public List<Actor> findAll();
public Actor findById(long id);
public Actor save(Actor actor);
public Actor update(long id, Actor actor);
	public void deleteById(long id);
}
