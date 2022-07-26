package com.springboot.rodrigopeleas.bookstoremanager.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rodrigopeleas.bookstoremanager.dto.MessageResponseDTO;
import com.springboot.rodrigopeleas.bookstoremanager.entity.Book;
import com.springboot.rodrigopeleas.bookstoremanager.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

  private BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping
  public MessageResponseDTO create(@RequestBody Book book) {
    return bookService.create(book);
  }

}
