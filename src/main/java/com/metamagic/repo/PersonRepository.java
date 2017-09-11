
package com.metamagic.repo;

import com.metamagic.entities.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author ketangote
 *
 */

public interface PersonRepository {

	Flux<Person> allPeople();

	Mono<Void> savePerson(Mono<Person> person);

	Mono<Person> getPerson(int id);
	
	
}
