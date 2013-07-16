package com.mapping;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends GraphRepository<Hello>
{
}
