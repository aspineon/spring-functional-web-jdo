package com.metamagic.handler;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.metamagic.entities.Department;
import com.metamagic.repo.DepartmentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 
 * @author ketangote
 *
 */

@Service
public class DepartmentHandlerImpl implements DepartmentHandler{

	@Autowired
	private DepartmentRepository repository;
	
	@Override
	public Mono<ServerResponse> createDepartment(ServerRequest request) {
		Mono<Department> department = request.bodyToMono(Department.class);
		return ServerResponse.ok().build(this.repository.saveDepartMent(department));
	}

	@Override
	public Mono<ServerResponse> listDepartment(ServerRequest request) {
		Flux<Department> departments = this.repository.allDepartMent();
		return ServerResponse.ok().contentType(APPLICATION_JSON).body(departments, Department.class);
	}

}
