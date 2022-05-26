package com.kakaye.graphqllearning1.service;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "dog not found")
public class DogNotFoundException extends RuntimeException implements GraphQLError {
    private Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundException() {
    }

    public DogNotFoundException(String message, String invalidString) {
        super(message);
        extensions.put("invalid breed",invalidString);
    }

    public DogNotFoundException(String message,Long invalidLocationId){
        super(message);
        extensions.put("invalidLocationId",invalidLocationId);
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
        return extensions;
    }
}
