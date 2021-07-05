package com.programming.techie.springredditclone.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.programming.techie.springredditclone.model.Book;
import com.programming.techie.springredditclone.security.JwtProvider;
import com.programming.techie.springredditclone.service.BookService;
import com.programming.techie.springredditclone.service.UserDetailsServiceImpl;

@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {

	@MockBean
	private BookService bookService;

	@MockBean private UserDetailsServiceImpl userDetailsService; 

	@MockBean private JwtProvider jwtProvider;

	@Autowired
	private MockMvc mockMvc;


	@Test
	@DisplayName("Should List All Books When making GET request to endpoint - /api/books/")
	public void shouldReturnListOfBooks() throws Exception {

		when(bookService.findAll()).thenReturn(Arrays.asList(
				new Book("123", "Spring 5 Recipes", "Marten Deinum", "Josh Long"),
				new Book("321", "Pro Spring MVC", "Marten Deinum", "Colin Yates")));

		mockMvc.perform(get("/api/books/"))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
		.andExpect(MockMvcResultMatchers.jsonPath("$[*].isbn", Matchers.containsInAnyOrder("123", "321")))
		.andExpect(MockMvcResultMatchers.jsonPath("$[*].title", Matchers.containsInAnyOrder("Spring 5 Recipes", "Pro Spring MVC")));
	}
	
	@Test
	@DisplayName("Should  return List All Books When making GET request to endpoint - /api/books/123")
	public void shouldReturn404WhenBookNotFound() throws Exception {

		when(bookService.find(anyString())).thenReturn(Optional.empty());

		mockMvc.perform(get("/api/books/123"))
				.andExpect(status().isNotFound());
	}

	@Test
	public void shouldReturnBookWhenFound() throws Exception {

		when(bookService.find(anyString())).thenReturn(
						Optional.of(new Book("123", "Spring 5 Recipes", "Marten Deinum", "Josh Long")));

		mockMvc.perform(get("/api/books/123"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.isbn", Matchers.equalTo("123")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.equalTo("Spring 5 Recipes")));
	}

	@Test
  public void shouldAddBook() throws Exception {

	  when(bookService.create(any(Book.class))).thenReturn(new Book("123456789", "Test Book Stored", "T. Author"));

	  mockMvc.perform(post("/api/books/")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{ \"isbn\" : \"123456789\"}, \"title\" : \"Test Book\", \"authors\" : [\"T. Author\"]"))
            .andExpect(status().isCreated());
           // .andExpect(header().string("Location", "http://localhost/books/123456789"));
  }
}
