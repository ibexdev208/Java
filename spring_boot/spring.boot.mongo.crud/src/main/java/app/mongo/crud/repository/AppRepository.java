package app.mongo.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.mongo.crud.model.Office;

@Repository
public interface AppRepository extends MongoRepository<Office, String>{

}
