package com.syscho.boot.scalars;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoidScalarConfiguration {

    @Bean
    public GraphQLScalarType voidScalar() {
        return GraphQLScalarType.newScalar()
                .name("VOID")
                .description("Void scalar type for graphql")
                .coercing(new Coercing() {
                    @Override
                    public Object serialize(final Object dataFetcherResult) {
                        return null;
                    }

                    @Override
                    public Object parseValue(final Object input) {
                        return null;
                    }

                    @Override
                    public Object parseLiteral(final Object input) {
                        return null;
                    }
                }).build();
    }
}