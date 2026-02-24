package com.springbootcrudapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcrudapi.dto.BookRequestDto;
import com.springbootcrudapi.dto.BookResponseDto;
import com.springbootcrudapi.entity.Book;
import com.springbootcrudapi.exception.ResourceNotFoundException;
import com.springbootcrudapi.mapper.BookMapper;
import com.springbootcrudapi.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	// Create
	@Override
	public BookResponseDto createBook(BookRequestDto dto) {
		Book book = BookMapper.toEntity(dto);
		Book savedBook = bookRepository.save(book);
		return BookMapper.toDto(savedBook);
	}

	// GetById
	@Override
	public BookResponseDto getBookById(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isEmpty()) {
			throw new ResourceNotFoundException("Book not found with id " + id);
		}
		Book book = optionalBook.get();
		return BookMapper.toDto(book);
	}

	// GetAll
	@Override
	public List<BookResponseDto> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		List<BookResponseDto> responseList = new ArrayList<>();
		for (Book book : books) {
			BookResponseDto dto = BookMapper.toDto(book);
			responseList.add(dto);
		}
		return responseList;
	}

	// Update
	@Override
	public BookResponseDto updateBook(Long id, BookRequestDto dto) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isEmpty()) {
			throw new ResourceNotFoundException("Book not found with id " + id);
		}
		Book book = optionalBook.get();
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setPrice(dto.getPrice());
		bookRepository.save(book);
		return BookMapper.toDto(book);
	}

	// Delete
	@Override
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isEmpty()) {
			throw new ResourceNotFoundException("Book not found with id " + id);
		}
		Book book = optionalBook.get();
		bookRepository.delete(book);
	}

}
