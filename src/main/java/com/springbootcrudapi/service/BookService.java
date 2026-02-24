package com.springbootcrudapi.service;

import java.util.List;

import com.springbootcrudapi.dto.BookRequestDto;
import com.springbootcrudapi.dto.BookResponseDto;

public interface BookService {
	
	BookResponseDto createBook(BookRequestDto dto);

    BookResponseDto getBookById(Long id);

    List<BookResponseDto> getAllBooks();

    BookResponseDto updateBook(Long id, BookRequestDto dto);

    void deleteBook(Long id);

}
