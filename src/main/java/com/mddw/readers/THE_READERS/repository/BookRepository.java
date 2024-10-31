package com.mddw.readers.THE_READERS.repository;

import com.mddw.readers.THE_READERS.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    void deleteById(int id);

}