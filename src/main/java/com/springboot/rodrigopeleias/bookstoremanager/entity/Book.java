package com.springboot.rodrigopeleias.bookstoremanager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false)
  @Min(value = 10)
  @Max(value = 9999)
  private Integer pages;

  @Column(nullable = false)
  @Min(value = 5)
  @Max(value = 100)
  private Integer chapters;

  @Column(nullable = false)
  @Min(value = 10)
  @Max(value = 13)
  private String isbn;

  @Column(name = "publisher_name", nullable = false, unique = true)
  private String publisherName;

  @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
  @JoinColumn(name = "author_id")
  private Author author;
}
