package com.springbootcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrudapi.dto.BookRequestDto;
import com.springbootcrudapi.dto.BookResponseDto;
import com.springbootcrudapi.service.BookService;
import com.springbootcrudapi.util.ApiResponse;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto dto) {
		BookResponseDto responseDto = bookService.createBook(dto);
		// Create HTTP response with status 200
		ResponseEntity<BookResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.CREATED);
		return response;
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable Long id) {
    	BookResponseDto bookById = bookService.getBookById(id);
    	ResponseEntity<BookResponseDto> response = new ResponseEntity<>(bookById, HttpStatus.OK);
    	return response;
    }
    
    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
		List<BookResponseDto> allBooks = bookService.getAllBooks();
		ResponseEntity<List<BookResponseDto>> response = new ResponseEntity<>(allBooks, HttpStatus.OK);
		return response;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(
            @PathVariable Long id,
            @RequestBody BookRequestDto dto) {
    	BookResponseDto updateBook = bookService.updateBook(id, dto);
    	ResponseEntity<BookResponseDto> response = new ResponseEntity<>(updateBook, HttpStatus.OK);
    	return response;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(new ApiResponse(true, "Book deleted successfully"));
    }

}
