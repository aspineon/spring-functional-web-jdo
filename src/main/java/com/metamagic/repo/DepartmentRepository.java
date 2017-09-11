package com.metamagic.repo;

import com.metamagic.entities.Department;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author ketangote
 *
 */

public interface DepartmentRepository {

	Flux<Department> allDepartMent();

	Mono<Void> saveDepartMent(Mono<Department> department);
}
