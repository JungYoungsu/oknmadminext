package com.kcb.oknmadminext.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kcb.oknmadminext.biz.company.CompanyService;
import com.kcb.oknmadminext.biz.user.UserService;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;


@CrossOrigin(maxAge = 3600)
@RestController
public class GraphQLController {
	private final GraphQL graphQL;
	
	public GraphQLController(UserService userService, CompanyService companyService) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
        		.withBasePackages("com.kcb.oknmadminext")
                .withOperationsFromSingleton(userService)
                .withOperationsFromSingleton(companyService)
                .generate();
        graphQL = GraphQL.newGraphQL(schema).build();
    }
	
	@PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> graphql(@RequestBody Map<String, Object> request, HttpServletRequest raw) {
        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
                .query(request.get("query").toString())
                .operationName(request.get("operationName") == null ? null : request.get("operationName").toString() )
                .context(raw)
                .build());
        return executionResult.toSpecification();
    }
}
