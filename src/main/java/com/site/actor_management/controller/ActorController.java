package com.site.actor_management.controller;

import com.site.actor_management.model.Actor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ActorController {

    List<Actor> actors = new ArrayList<>();

    public ActorController() {
        actors.add(new Actor(1, "Abebe", "Male", 25));
        actors.add(new Actor(2, "Martha", "Female", 22));
        actors.add(new Actor(3, "Dawit", "Male", 28));
    }



    @GetMapping("/actor")
    public List<Actor> getActorDetails() {
        return actors;
    }

    @GetMapping("/actor/{id}")
    public Actor getActorById(@PathVariable int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                return actor;
            }
        }
        return null;
    }

    @PostMapping("/actor")
    public Actor addActor(@RequestBody Actor actor) {
        actors.add(actor);
        return actor;
    }
    @PutMapping("/actor/{id}")
    public Actor updateActor(@PathVariable int id, @RequestBody Actor updatedActor) {

        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actor.setName(updatedActor.getName());
                actor.setGender(updatedActor.getGender());
                actor.setAge(updatedActor.getAge());

                return actor;
            }
        }

        return null;
    }

    @DeleteMapping("/actor/{id}")
    public void deleteActor(@PathVariable int id) {
        for (Actor actor : actors) {
            if (actor.getId() == id) {
                actors.remove(actor);
                return;
            }
        }
    }

}
