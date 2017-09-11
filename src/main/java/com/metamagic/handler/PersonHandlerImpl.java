

package com.metamagic.handler;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.metamagic.entities.Person;
import com.metamagic.repo.PersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author ketangote
 *
 */

@Service
public class PersonHandlerImpl implements PersonHandler{
		
	@Autowired
	private PersonRepository repository;

	@Override
	public Mono<ServerResponse> createPerson(ServerRequest request) {
	
		Mono<Person> person = request.bodyToMono(Person.class);
		return ServerResponse.ok().build(this.repository.savePerson(person));
	}

	@Override
	public Mono<ServerResponse> listPeople(ServerRequest request) {
		Flux<Person> people = this.repository.allPeople();
		return ServerResponse.ok().contentType(APPLICATION_JSON).body(people, Person.class);
	}

	@Override
	public Mono<ServerResponse> getPerson(ServerRequest request) {
		
		int personId = Integer.valueOf(request.pathVariable("id"));
		
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		
		Mono<Person> personMono = this.repository.getPerson(personId);
		
		return personMono.flatMap(person -> ServerResponse.ok().contentType(APPLICATION_JSON).syncBody(person));
	}

}
