package com.askme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.askme.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String>{

}
