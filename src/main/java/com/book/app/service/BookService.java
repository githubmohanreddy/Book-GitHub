package com.book.app.service;

import com.book.app.entity.Book;
import com.book.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);

    }
    public Book updateBook(String id, Book book) {
        return bookRepository.save(book);


//       return bookRepository.findById(book).map(b->{
//           book.setBookName(book.getBookName());
//           book.setBookAuthor(book.getBookAuthor());
//           book.setGenre(book.getGenre());
//           return bookRepository.save(book);
//
//       }).orElseThrow(()->new RuntimeException("Given Id is not Exist! "+id));


    }

    public Book getBookById(String id) {
        return bookRepository.getById(id);

    }

    public void deleteBook(String id) {
        Book book = bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found with ID: \" + id"));

        bookRepository.delete(book);
    }

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }
}
