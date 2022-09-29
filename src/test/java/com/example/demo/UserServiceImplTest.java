package com.example.demo;

import static org.mockito.Mockito.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.exception.UserException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceImpl;


@AutoConfigureMockMvc
@SpringBootTest
public class UserServiceImplTest
{
    @Mock
    private UserRepository userRepo;
    
    
    @InjectMocks
    private UserServiceImpl userService;
    
    
    @Autowired
    private MockMvc mockMvcObj;

    
    @BeforeEach
    public void init()
    {
        MockitoAnnotations.openMocks(this);
        mockMvcObj = MockMvcBuilders.standaloneSetup(userService).build();
        
    }
    
   private List<User> userList = new ArrayList<>();
   
    @Test
    public void UsersTest() throws Exception, UserException
    {
      when(userRepo.findAll()).thenReturn(Stream.of(new User(1,"shivaji@gmail.com","shivaji123@123")).collect(Collectors.toList()));
      assertEquals(1,userService.getAllUsers().size());
    }
   
    @Test
    public void getAllUserSuccess() throws Exception, UserException
    {
        User user = new User();
        
        user.setUserId(1);
        user.setUsername("shivaji@gmail.com");
        
        userList.add(user);
        
        when(userRepo.findAll()).thenReturn(userList);
        
        
        List<User> uList = userService.getAllUsers();
        
        assertEquals(userList, uList);
        
    }
    
    @Test
    public void getAllUserFailure() throws Exception, UserException
    {
        when(userRepo.findAll()).thenReturn(null);
        
        List<User> uList = userService.getAllUsers();
        
        assertNull(uList);   
    }
}