package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.PatientException;
import com.example.demo.exception.UserException;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth/user/v1")
//@SecurityRequirement(name="userController")
public class AuthenticationController {

	private Map<String,String> mObj = new HashMap<String,String>();
	
	@Autowired
 	private UserServiceImpl userServiceImpl;
 	
	
	
 	@PostMapping("/registerUser")
 	public ResponseEntity<?> addUser(@RequestBody User user)throws UserException
 	{
 		if(userServiceImpl.addUser(user)!=null)
 		{
 			return new ResponseEntity<User>(user, HttpStatus.CREATED);
 		}
 		return new ResponseEntity<String>("user is not registered", HttpStatus.CREATED);
 	}
 	
 	@PostMapping("/loginUser")
 	public ResponseEntity<?> loginUser(@RequestBody User user)throws UserException
 	{
 		try
 		{
 			mObj.put("message", "User successfully logged in");		String jwtToken =generateToken(user.getUsername(),user.getPassword()); 			mObj.put("message", "User has successfully logged in!");
 			mObj.put("token", jwtToken);
 		}
 		catch(Exception e)
 		{
 			mObj.put("message", "User unsuccessfully logged in");
 			mObj.put("token", null);
 		}
 		return new ResponseEntity<>(mObj, HttpStatus.CREATED);
		}
 	
 	@GetMapping("/user/all")
    public ResponseEntity<?> getAllUsers() throws UserException
    {
        List<User> userList = userServiceImpl.getAllUsers();
        if(userList.isEmpty())
        {
            return new ResponseEntity<String>("User list is empty", HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<>(userList, HttpStatus.OK);
    }
 	
	public String generateToken(String username, String password) throws ServletException, Exception, UserException 
	{
		String jwtToken = "";

		if (username == null || password == null) 
		{
		throw new ServletException("Please provide valid username and password");
		}

		boolean flag = userServiceImpl.validateUserLogin(username, password);

		if (!flag)
		{			throw new ServletException("Invalid credentials");
		} 
		else
		{
		jwtToken = Jwts.builder().setSubject(username).setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis()+3000000))
					.signWith(SignatureAlgorithm.HS256, "my secret sign").compact();
	}

		return jwtToken;
	}
@ExceptionHandler(UserException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public ResponseEntity<String> handleUserException(UserException exception){
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
}

}
