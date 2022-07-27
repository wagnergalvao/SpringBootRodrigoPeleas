package com.springboot.rodrigopeleias.bookstoremanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rodrigopeleias.bookstoremanager.dto.BookDTO;
import com.springboot.rodrigopeleias.bookstoremanager.dto.MessageResponseDTO;
import com.springboot.rodrigopeleias.bookstoremanager.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

  @Autowired
  private BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping
  public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
    return bookService.create(bookDTO);
  }

}
