package com.app.repo;

import com.app.model.Books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books , Integer> {

}
    

