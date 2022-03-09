package com.askme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.askme.model.NormalUser;

public interface NormalUserRepository extends MongoRepository<NormalUser, String>{
	@Query("{userName:'?0'}")
    NormalUser findUser(String userName); 

}
