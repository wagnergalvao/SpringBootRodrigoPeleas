package com.springboot.rodrigopeleias.bookstoremanager.service;

import static com.springboot.rodrigopeleias.bookstoremanager.utils.BookUtils.createFakeBook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springboot.rodrigopeleias.bookstoremanager.dto.BookDTO;
import com.springboot.rodrigopeleias.bookstoremanager.entity.Book;
import com.springboot.rodrigopeleias.bookstoremanager.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

  @Mock
  private BookRepository bookRepository;

  @InjectMocks
  private BookService bookService;

  @Test
  void WhenGetIsCalledWithExistingIdThenReturnThisBook() {

    Book expectedFoundBook = createFakeBook();

    when(bookRepository.findById(expectedFoundBook.getId()))
        .thenReturn(Optional.of(expectedFoundBook));

    BookDTO bookDTO = bookService.findById(expectedFoundBook.getId());

    assertEquals(expectedFoundBook.getName(), bookDTO.getName());
    assertEquals(expectedFoundBook.getIsbn(), bookDTO.getIsbn());
    assertEquals(expectedFoundBook.getPublisherName(), bookDTO.getPublisherName());

  }
}
