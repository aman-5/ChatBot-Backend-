package com.askme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.askme.model.AccountDetails;

public interface AccountDetailsRepository extends MongoRepository<AccountDetails, String>{

}
