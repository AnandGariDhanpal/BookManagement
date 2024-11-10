package com.example.bookmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmanagement.Entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    public Book findByTitle(String Title);
    
} 
