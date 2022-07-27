package com.springboot.rodrigopeleias.bookstoremanager.service;

import org.springframework.stereotype.Service;

import com.springboot.rodrigopeleias.bookstoremanager.dto.BookDTO;
import com.springboot.rodrigopeleias.bookstoremanager.dto.MessageResponseDTO;
import com.springboot.rodrigopeleias.bookstoremanager.entity.Book;
import com.springboot.rodrigopeleias.bookstoremanager.mapper.BookMapper;
import com.springboot.rodrigopeleias.bookstoremanager.repository.BookRepository;

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
