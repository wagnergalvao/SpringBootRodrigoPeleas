package com.springboot.rodrigopeleas.bookstoremanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.springboot.rodrigopeleas.bookstoremanager.dto.BookDTO;
import com.springboot.rodrigopeleas.bookstoremanager.entity.Book;

@Mapper
public interface BookMapper {

  BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

  Book toModel(BookDTO bookDTO);

  BookDTO toDTO(Book book);

}
