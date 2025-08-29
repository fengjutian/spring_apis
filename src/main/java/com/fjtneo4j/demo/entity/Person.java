package com.fjtneo4j.demo.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import lombok.Data;

@Node("Person")  // 节点标签
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;
}
