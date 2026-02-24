package com.springbootcrudapi.mapper;

import com.springbootcrudapi.dto.BookRequestDto;
import com.springbootcrudapi.dto.BookResponseDto;
import com.springbootcrudapi.entity.Book;

public class BookMapper {
	
	public static Book toEntity(BookRequestDto dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        return book;
    }

    public static BookResponseDto toDto(Book book) {
        BookResponseDto dto = new BookResponseDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPrice(book.getPrice());
        return dto;
    }

}
