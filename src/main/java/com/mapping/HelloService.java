package com.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

@Service
public class HelloService
{
    @Autowired
    HelloRepository repository;

    @Transactional
    public Hello createHello() {
        Hello h = new Hello();
        h.setMessage( "Hello World" );
        return repository.save( h );
    }

    @Transactional
    public Iterator<Hello> getHellos() {
        return repository.findAll().iterator();
    }
}
