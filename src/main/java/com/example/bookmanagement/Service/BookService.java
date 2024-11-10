package com.example.bookmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookmanagement.Entities.Book;
import com.example.bookmanagement.Repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public Book getBookByName(String name) {
        return bookRepository.findByTitle(name);
    }
    public Book updateBook(Book book){
        return bookRepository.save(book);
    }
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
