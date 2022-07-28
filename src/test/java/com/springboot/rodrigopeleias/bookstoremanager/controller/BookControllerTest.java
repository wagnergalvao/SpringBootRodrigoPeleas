package com.springboot.rodrigopeleias.bookstoremanager.controller;

import static com.springboot.rodrigopeleias.bookstoremanager.utils.BookUtils.asJsonString;
import static com.springboot.rodrigopeleias.bookstoremanager.utils.BookUtils.createFakeBookDTO;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.springboot.rodrigopeleias.bookstoremanager.dto.BookDTO;
import com.springboot.rodrigopeleias.bookstoremanager.dto.MessageResponseDTO;
import com.springboot.rodrigopeleias.bookstoremanager.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

  /**
   *
   */
  private static final String BOOK_API_URL_PATH = "/api/v1/books";

  private MockMvc mockMvc;

  @Mock
  private BookService BookService;

  @InjectMocks
  private BookController bookController;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(bookController)
        .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
        .setViewResolvers((viewName, locale) -> new MappingJackson2JsonView())
        .build();
  }

  @Test
  void WhenPostCreateIsCalledWithBookDataThenBookShouldBeCreated() throws Exception {

    BookDTO bookDTO = createFakeBookDTO();
    MessageResponseDTO expectMessageResponseDTO = MessageResponseDTO.builder()
        .message("Book created with ID " + bookDTO.getId())
        .build();

    when(BookService.create(bookDTO))
        .thenReturn(expectMessageResponseDTO);

    mockMvc.perform(post(BOOK_API_URL_PATH)
        .contentType(APPLICATION_JSON)
        .content(asJsonString(bookDTO)))
        .andExpect(status().isOk())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.message",
                Is.is(expectMessageResponseDTO.getMessage())));
  }

  @Test
  void WhenPostCreateIsCalledWithInvalidSIBNThenBadRequestShouldBeReturned() throws Exception {
    BookDTO bookDTO = createFakeBookDTO();
    bookDTO.setIsbn("invalid isbn");

    mockMvc.perform(post(BOOK_API_URL_PATH)
        .contentType(APPLICATION_JSON)
        .content(asJsonString(bookDTO)))
        .andExpect(status().isBadRequest());
  }

  @Test
  void WhenPostCreateIsCalledWithUnnamedBookhenBadRequestShouldBeReturned() throws Exception {
    BookDTO bookDTO = createFakeBookDTO();
    bookDTO.setName("");

    mockMvc.perform(post(BOOK_API_URL_PATH)
        .contentType(APPLICATION_JSON)
        .content(asJsonString(bookDTO)))
        .andExpect(status().isBadRequest());
  }
}
