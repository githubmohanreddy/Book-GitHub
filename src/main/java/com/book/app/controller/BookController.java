package com.book.app.controller;

import com.book.app.entity.Book;
import com.book.app.msg.resp.MessageResponse;
import com.book.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/v1")
public class BookController {

    private final BookService bookService; // This constructor Based dependancy
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){

        Book saveBook = bookService.addBook(book);
        return ResponseEntity.ok(saveBook);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<MessageResponse> updateBook(@PathVariable String  id, @RequestBody Book book){
        bookService.updateBook(id, book);
        return ResponseEntity.ok(new MessageResponse("The Given Data is Updated!"));
    }

    // Updating the Book Details without Response
//    @PutMapping("/updateBook/{id}")
//    public ResponseEntity<Book> updateBook(@PathVariable String  id, @RequestBody Book book){
//        Book updateBook = bookService.updateBook(id, book);
//        return ResponseEntity.ok(updateBook);
//    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") String id){
     Book getBook = bookService.getBookById(id);
     return ResponseEntity.ok(getBook);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<MessageResponse> deleteBook(@PathVariable("id") String id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(new MessageResponse("Data deleted successfully. ID: " + id));
    }


}


//echo "# github-repository" >> README.md
//git init
//git add README.md
//git commit -m "first commit"
//git branch -M main
//git remote add origin https://github.com/githubmohanreddy/github-repository.git
//git push -u origin main