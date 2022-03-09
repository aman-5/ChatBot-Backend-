package com.askme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.askme.model.OtherIssues;

public interface OtherIssuesRepository extends MongoRepository<OtherIssues, String>{

}
