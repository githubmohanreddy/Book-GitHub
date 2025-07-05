package com.book.app.repository;

import com.book.app.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository  extends MongoRepository<Book, String> {
   public Book getById(String bid);
}
