
package com.site.actor_management.service;

import com.site.actor_management.model.Actor;
import com.site.actor_management.repo.ActorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private final ActorRepo actorRepo;

    public ActorService(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }

    public List<Actor> getAllActors() {
        return actorRepo.findAll();
    }

    public Optional<Actor> getActorById(int id) {
        return actorRepo.findById(id);
    }

    public Actor addActor(Actor actor) {
        return actorRepo.save(actor);
    }

    public Actor updateActor(Actor actor) {
        return actorRepo.save(actor);
    }

    public void deleteActor(int id) {
        actorRepo.deleteById(id);
    }
}
