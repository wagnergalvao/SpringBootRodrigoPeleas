package com.springboot.rodrigopeleas.bookstoremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rodrigopeleas.bookstoremanager.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
