package com.askme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.askme.model.Shopping;


public interface ShoppingRepository extends MongoRepository<Shopping, String>{

}
