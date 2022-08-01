package com.springboot.rodrigopeleias.bookstoremanager.dto;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

  private Long id;

  @NotBlank(message = "name: required")
  @Size(min = 5, max = 200, message = "name: must be between 5 and 200 characters long")
  private String name;

  @NotNull(message = "pages: positive number value is required")
  @Min(value = 10, message = "pages: positive number, min 10 is required")
  @Max(value = 9999, message = "pages: positive number, max 9999 is required")
  private Integer pages;

  @NotNull(message = "chapters: positive number value is required")
  @Min(value = 5, message = "chapters: positive number, min 5 is required")
  @Max(value = 100, message = "pages: positive number, max 100 is required")
  private Integer chapters;

  @NotBlank(message = "isbn: required")
  @Size(max = 100, message = "isbn: format must be ISBN-10 or ISBN-13 format")
  @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$", message = "isbn: format must be ISBN-10 or ISBN-13 format")
  private String isbn;

  @NotBlank(message = "publisherName: required")
  @Size(min = 5, max = 200, message = "publisherName: must be between 5 and 200 characters long")
  private String publisherName;

  @Valid()
  @NotNull
  private AuthorDTO author;

}
