package com.metamagic.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

/**
 * 
 * @author ketangote
 *
 */

public interface PersonHandler {

	public Mono<ServerResponse> createPerson(ServerRequest request) ;
	
	public Mono<ServerResponse> listPeople(ServerRequest request);
	
	
	public Mono<ServerResponse> getPerson(ServerRequest request);
}
