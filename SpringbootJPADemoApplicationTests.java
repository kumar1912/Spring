package com.programming.techie.springredditclone.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.programming.techie.springredditclone.model.User1;
import com.programming.techie.springredditclone.repository.UserRepository1;
import com.programming.techie.springredditclone.security.JwtProvider;
import com.programming.techie.springredditclone.service.BookService;
import com.programming.techie.springredditclone.service.PostService;
import com.programming.techie.springredditclone.service.UserDetailsServiceImpl;

/**
 * @author Kumar D
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class SpringbootJPADemoApplicationTests {

    @MockBean
    private PostService postService;
    @MockBean
    private UserDetailsServiceImpl userDetailsService;
    @MockBean
    private JwtProvider jwtProvider;

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
	private BookService bookService;
    
	@Autowired
	private UserRepository1 userRepository1;
	
	@Test
	public void findAllUsers()  {
		List<User1> users = userRepository1.findAll();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
		
	}
	
	@Test
	public void findUserById()  {
		User1 user = userRepository1.getOne(1);
		assertNotNull(user);
	}
	
	@Test @Ignore
	public void createUser() {
		User1 user = new User1(null, "Paul", "paul@gmail.com");
		User1 savedUser = userRepository1.save(user);
		User1 newUser = userRepository1.findById(savedUser.getId()).get();
		assertEquals("Paul", newUser.getName());
		assertEquals("paul@gmail.com", newUser.getEmail());
	}
	
	@Test
	public void getUsersSortByName() {
		Sort sort = new Sort(Direction.ASC, "name");
		List<User1> users = userRepository1.findAll(sort);
		assertNotNull(users);
	}
	
	@Test
	public void getUsersSortByNameAscAndIdDesc() {		
		Order order1 = new Order(Direction.ASC, "name");
		Order order2 = new Order(Direction.DESC, "id");
		Sort sort = Sort.by(order1, order2);
		List<User1> users = userRepository1.findAll(sort);
		assertNotNull(users);
	}
	
	@Test
	public void getUsersByPage() {
		Sort sort = new Sort(Direction.ASC, "name");
		int size = 25;
		int page = 0; //zero-based page index.
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<User1> usersPage = userRepository1.findAll(pageable);
		System.out.println(usersPage.getTotalElements()); //Returns the total amount of elements.
		System.out.println(usersPage.getTotalPages());//Returns the number of total pages.
		System.out.println(usersPage.hasNext());
		System.out.println(usersPage.hasPrevious());
		List<User1> usersList = usersPage.getContent();
		assertNotNull(usersList);
	}
}
