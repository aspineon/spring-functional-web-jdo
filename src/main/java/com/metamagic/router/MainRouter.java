package com.metamagic.router;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.metamagic.handler.DepartmentHandler;
import com.metamagic.handler.PersonHandler;

/**
 * 
 * @author ketangote
 *
 */

@Service
public class MainRouter {

	@Autowired
	private PersonHandler handler;
	
	@Autowired 
	private DepartmentHandler deptHandler;
	
	@Bean
	public RouterFunction<ServerResponse> routes(){
		
		return 
				/**ROUTING RULES FOR PERSON**/
				nest(path("/person"),nest(accept(APPLICATION_JSON),
					route(GET("/{id}"), handler::getPerson)
					.andRoute(method(HttpMethod.GET), handler::listPeople))
					.andRoute(POST("/").and(contentType(APPLICATION_JSON)), handler::createPerson))
				
				/**ROUTING RULES FOR DEPRTMENT**/
				.andNest(path("/dept"),nest(accept(APPLICATION_JSON),
						route(GET("/"), deptHandler::listDepartment)
						.andRoute(POST("/").and(contentType(APPLICATION_JSON)), deptHandler::createDepartment)));
	}
}
