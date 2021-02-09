package com.bookstore.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.Book;

@Repository
public interface AppDao extends MongoRepository<Book, String>{

}
