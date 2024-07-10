package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bindings.ActivateUser;
import com.nt.bindings.LoginCredentials;
import com.nt.bindings.RecoverPassword;
import com.nt.bindings.UserAccount;
import com.nt.service.IUserMgmtService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user-api")
@Slf4j
public class UserMgmtOperationsController {
	
	@Autowired
	private IUserMgmtService userService;
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveUser(@RequestBody UserAccount account){
		//use service
		try {
			String resultMsg=userService.registerUser(account);
			return new ResponseEntity<>(resultMsg,HttpStatus.CREATED);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping("/activate")
	public ResponseEntity<Object> activateUser(@RequestBody ActivateUser user){
		//use service
		try {
		String resultMsg=userService.activateUserAccount(user);
		return new ResponseEntity<>(resultMsg,HttpStatus.CREATED);
		}
	catch(Exception e) {
		log.error(e.getMessage());
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> performLogin(@RequestBody LoginCredentials credentials){
		//use service
		try {
			String resultMsg=userService.login(credentials);
			return new ResponseEntity<>(resultMsg,HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/report")
	public ResponseEntity<Object> showUsers(){
		try {
			List<UserAccount> list=userService.listUsers();
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Object> showUserById(@PathVariable Integer id){
		try {
			UserAccount account=userService.showUserByUserId(id);
			return new ResponseEntity<>(account,HttpStatus.OK);
			}
			catch(Exception e) {
				log.error(e.getMessage());
				return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	
	@GetMapping("/find/{email}/{name}")
 public ResponseEntity<Object> showUserByEmailAndName(@PathVariable String email,@PathVariable String name){
		try {
			UserAccount account=userService.showUserByEmailAndName(email, name);
			return new ResponseEntity<>(account,HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateUserDetails(@RequestBody UserAccount account){
		try {
			String resultMsg=userService.updateUser(account);
			return new ResponseEntity<>(resultMsg,HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable Integer id){
		try {
			String resultMsg=userService.deleteUserById(id);
			return new ResponseEntity<>(resultMsg,HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PatchMapping("/change/{id}/{status}")
	public ResponseEntity<Object> changeStatus(@PathVariable Integer id, @PathVariable String status){
		try {
			String resultMsg=userService.changeUserStatus(id, status);
			return new ResponseEntity<>(resultMsg,HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/recoverPassword")
	public ResponseEntity<Object> recoverPassword(@RequestBody RecoverPassword recover){
		try {
			String resultMsg=userService.recoverPassword(recover);
			return new ResponseEntity<>(resultMsg,HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}//class










