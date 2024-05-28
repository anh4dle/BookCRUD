package com.example.demo.Repositories;

import com.example.demo.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //Declare custom query methods
    Book findByisbn(int isbn);
    Book findByTitle(String title);
}