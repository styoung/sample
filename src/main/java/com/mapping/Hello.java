package com.mapping;

import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Hello
{
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }
}
