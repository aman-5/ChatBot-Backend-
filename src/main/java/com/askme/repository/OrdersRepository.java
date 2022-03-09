package com.askme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.askme.model.Orders;

public interface OrdersRepository extends MongoRepository<Orders, String>{

}
