package com.library.library_management_api.repository;

import com.library.library_management_api.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;    

public interface BookRepository extends JpaRepository<Book, Long> {
        // JpaRepository provides CRUD operations and more for the Book entity.
}

