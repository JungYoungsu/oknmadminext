package com.kcb.oknmadminext.graphql;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class UserProvider implements UserDetails {

	private GraphQL graphQL;

	private final UsersDataFetcher usersDataFetcher;

	public UserProvider(UsersDataFetcher usersDataFetcher) {
		super();
		this.usersDataFetcher = usersDataFetcher;
	}

	@Value("classpath:graphql/users.graphql")
	Resource resource;

	@Override
	public ExecutionResult execute(String query) {
		return graphQL.execute(query);
	}

	@PostConstruct
	private void loadSchema() throws IOException {

		// Load Books into the Book Repository
		// loadDataIntoHSQL();

		// get the schema
		File schemaFile = resource.getFile();
		// parse schema
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
	}

	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring.dataFetcher("user", usersDataFetcher)).build();
	}
}
