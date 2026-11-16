
package com.site.actor_management.controller;

import com.site.actor_management.model.Actor;
import com.site.actor_management.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }

    @GetMapping("/{id}")
    public Optional<Actor> getActorById(@PathVariable int id) {
        return actorService.getActorById(id);
    }

    @PostMapping
    public Actor addActor(@RequestBody Actor actor) {
        return actorService.addActor(actor);
    }

    @PutMapping("/{id}")
    public Actor updateActor(@PathVariable int id,
                             @RequestBody Actor actor) {
        actor.setId(id);
        return actorService.updateActor(actor);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable int id) {
        actorService.deleteActor(id);
    }
}
