package com.fjtneo4j.demo.repository;

import com.fjtneo4j.demo.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {
    // 可以扩展自定义查询
    Person findByName(String name);
}
