package bookstore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import bookstore.model.Book;

public interface BookRepository extends MongoRepository<Book, String>{

}