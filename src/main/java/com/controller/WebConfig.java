package com.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.controller" )
public class WebConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void configureContentNegotiation( ContentNegotiationConfigurer configurer ) {
        configurer.favorPathExtension( false ).
                favorParameter( false ).
                parameterName( "mediaType" ).
                ignoreAcceptHeader( true ).
                useJaf( false ).
                defaultContentType( MediaType.APPLICATION_JSON ).
                mediaType( "json", MediaType.APPLICATION_JSON );
    }

    @Override
    public void configureMessageConverters( List<HttpMessageConverter<?>> converters ) {
        converters.add( jackson2HttpMessageConverter() );
    }

    @Bean
    MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setPrettyPrint( true );
        return converter;
    }
}