package com.springboot.rodrigopeleias.bookstoremanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springboot.rodrigopeleias.bookstoremanager.dto.BookDTO;
import com.springboot.rodrigopeleias.bookstoremanager.entity.Book;

@Mapper
public interface BookMapper {

  BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

  Book toModel(BookDTO bookDTO);

  BookDTO toDTO(Book book);
}
