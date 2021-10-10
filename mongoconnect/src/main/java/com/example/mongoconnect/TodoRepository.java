package com.example.mongoconnect;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface TodoRepository extends MongoRepository<TodoDTO,Integer> {
}
