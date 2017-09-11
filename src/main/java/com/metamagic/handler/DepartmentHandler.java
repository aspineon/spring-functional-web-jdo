package com.metamagic.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * 
 * @author ketangote
 *
 */
public interface DepartmentHandler {

	public Mono<ServerResponse> createDepartment(ServerRequest request) ;
	
	public Mono<ServerResponse> listDepartment(ServerRequest request);
}
