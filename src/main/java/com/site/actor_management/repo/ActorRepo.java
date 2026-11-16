
package com.site.actor_management.repo;

import com.site.actor_management.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepo extends JpaRepository<Actor, Integer> {

}
