package bookstore.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import bookstore.model.Book;

@Repository
public class BookSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;


	public Collection<Book> searchBooks(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("title").regex(text, "i"), 
						Criteria.where("genre").regex(text, "i"), 
						Criteria.where("author").regex(text, "i"))
				), Book.class);
	}

//	list all books with sort
//	public Collection<Book> allBooks() {
//		Query query = new Query();
//		query.with(Sort.by(Sort.Direction.ASC, "genre"));
//		return mongoTemplate.find(query,Book.class);
//	}
	
	
//	List all books per genre
	public Collection<Book> dbGenre() {
		Query query = new Query();
		query.addCriteria(Criteria.where("genre").regex("^d"));
		return mongoTemplate.find(query, Book.class);
		 
	}
	
	public Collection<Book> dbCount() {
		Query query = new Query();
		query.addCriteria(Criteria.where("genre").regex("^d"));
		return mongoTemplate.find(query, Book.class);
		 
	}

	public Collection<Book> javaGenre() {
		Query query = new Query();
		query.addCriteria(Criteria.where("genre").regex("^j"));
		return mongoTemplate.find(query, Book.class);
	}

	public Collection<Book> webGenre() {
		Query query = new Query();
		query.addCriteria(Criteria.where("genre").regex("^w"));
		return mongoTemplate.find(query, Book.class);
	}
	
	
}
