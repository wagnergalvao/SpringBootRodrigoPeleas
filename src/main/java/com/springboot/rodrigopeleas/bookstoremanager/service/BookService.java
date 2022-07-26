package com.springboot.rodrigopeleas.bookstoremanager.service;

import org.springframework.stereotype.Service;

import com.springboot.rodrigopeleas.bookstoremanager.dto.BookDTO;
import com.springboot.rodrigopeleas.bookstoremanager.dto.MessageResponseDTO;
import com.springboot.rodrigopeleas.bookstoremanager.entity.Book;
import com.springboot.rodrigopeleas.bookstoremanager.mapper.BookMapper;
import com.springboot.rodrigopeleas.bookstoremanager.repository.BookRepository;

@Service
public class BookService {

  private BookRepository bookRepository;

  private final BookMapper bookMapper = BookMapper.INSTANCE;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public MessageResponseDTO create(BookDTO bookDTO) {

    Book bookToSave = bookMapper.toModel(bookDTO);

    Book savedBook = bookRepository.save(bookToSave);
    return MessageResponseDTO.builder()
        .message("Book created with ID " + savedBook.getId())
        .build();

  }

}
