package com.springboot.rodrigopeleias.bookstoremanager.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.springboot.rodrigopeleias.bookstoremanager.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

  private MockMvc mockMvc;

  private BookService BookService;

  private BookController bookController;
}
