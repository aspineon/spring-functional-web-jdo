package com.metamagic.repo;

import java.util.List;

import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metamagic.entities.Department;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author ketangote
 *
 */

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{

	@Autowired
	PersistenceManagerFactory pmf;
	
	@Override
	public Flux<Department> allDepartMent() {
		Query query = pmf.getPersistenceManager().newQuery(Department.class);
		List<Department> departments =  (List<Department>) query.execute();
		return Flux.fromIterable(departments);
	}

	@Override
	public Mono<Void> saveDepartMent(Mono<Department> departmentMono) {
		return departmentMono.doOnNext(dept -> {
			Department p = new Department(dept.getName());
			pmf.getPersistenceManager().makePersistent(p);
			System.out.println("Department SAVED "+p.getId());
		}).thenEmpty(Mono.empty());
	}

	
}
