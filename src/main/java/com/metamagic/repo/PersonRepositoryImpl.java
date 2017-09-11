
package com.metamagic.repo;

import java.util.List;

import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metamagic.entities.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author ketangote
 *
 */

@Repository
public class PersonRepositoryImpl implements PersonRepository {

	
	@Autowired
	PersistenceManagerFactory pmf;
	
	public PersonRepositoryImpl() {
	}

	@Override
	public Flux<Person> allPeople() {
		Query query = pmf.getPersistenceManager().newQuery(Person.class);
		List<Person> persons =  (List<Person>) query.execute();
		return Flux.fromIterable(persons);
	}

	@Override
	public Mono<Void> savePerson(Mono<Person> personMono) {
		return personMono.doOnNext(person -> {
			Person p = new Person(person.getName());
			pmf.getPersistenceManager().makePersistent(p);
			System.out.println("PERSON SAVED "+p.getId());
		}).thenEmpty(Mono.empty());
	}


	@Override
	public Mono<Person> getPerson(int id) {
		Person person = pmf.getPersistenceManager().getObjectById(Person.class,id);
		return Mono.justOrEmpty(person);
	}
	
	
}
