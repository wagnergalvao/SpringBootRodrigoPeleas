package com.springboot.rodrigopeleas.bookstoremanager.service;

import org.springframework.stereotype.Service;

import com.springboot.rodrigopeleas.bookstoremanager.dto.BookDTO;
import com.springboot.rodrigopeleas.bookstoremanager.dto.MessageResponseDTO;
import com.springboot.rodrigopeleas.bookstoremanager.entity.Book;
import com.springboot.rodrigopeleas.bookstoremanager.repository.BookRepository;

@Service
public class BookService {

  private BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public MessageResponseDTO create(BookDTO bookDTO) {

    Book bookToSave = Book.builder()
        .name(bookDTO.getName())
        .pages(bookDTO.getPages())
        .chapters(bookDTO.getChapters())
        .isbn(bookDTO.getIsbn())
        .publisherName(bookDTO.getPublisherName())
        .build();

    Book savedBook = bookRepository.save(bookToSave);
    return MessageResponseDTO.builder()
        .message("Book created with ID " + savedBook.getId())
        .build();

  }

}
