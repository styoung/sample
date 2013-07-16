package com.mapping;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableNeo4jRepositories( basePackages = "com.mapping")
@EnableTransactionManagement( mode = AdviceMode.ASPECTJ )
@ComponentScan( basePackages = "com.mapping" )
public class MainConfig extends Neo4jConfiguration
{
    @Bean( destroyMethod = "shutdown" )
    public GraphDatabaseService graphDatabaseService() {
        Map<String, String> options = new HashMap<>();
        options.put( "allow_store_upgrade", "true" );
        options.put( "enable_remote_shell", "true" );
        return new GraphDatabaseFactory().newEmbeddedDatabaseBuilder( "/usr/share/actual/db" ).setConfig( options ).newGraphDatabase();
    }
}
