package com.syscho.boot.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class NoDataFoundException extends RuntimeException implements GraphQLError {

    public NoDataFoundException(String msg) {
        super(String.format("No Data found for id %s ", msg));
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("Error", "Invalid Request");
    }

}
