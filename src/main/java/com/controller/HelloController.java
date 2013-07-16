package com.controller;

import com.mapping.Hello;
import com.mapping.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Iterator;

@Controller
public class HelloController
{
    private static final Logger log = LoggerFactory.getLogger( HelloController.class );

    @Autowired
    HelloService service;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/", produces = "application/json", method = RequestMethod.GET )
    public
    @ResponseBody
    Iterator<Hello> findAll() {
        service.createHello();
        return service.getHellos();
    }
}