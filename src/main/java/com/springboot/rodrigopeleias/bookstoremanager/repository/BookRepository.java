package com.springboot.rodrigopeleias.bookstoremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rodrigopeleias.bookstoremanager.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
