package com.example.bookmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookmanagement.Entities.Book;
import com.example.bookmanagement.Service.BookService;

@RestController
@RequestMapping("/book/v1")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping("/addBook")
    public ResponseEntity<Book> addbook(@RequestBody  Book book){
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
    }
    @GetMapping("/getBook/{bookname}")
    public ResponseEntity<Book> getBookByName(@PathVariable("bookname") String name) {
       final Book bookbyname =  bookService.getBookByName(name);
       return ResponseEntity.ok(bookbyname);
    }
    @PutMapping("/updateBook")
    public ResponseEntity<Book> updatebook(@RequestBody  Book book){
        Book updatedBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deletebook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
