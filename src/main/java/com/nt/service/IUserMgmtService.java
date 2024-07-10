package com.nt.service;

import java.util.List;

import org.springframework.dao.OptimisticLockingFailureException;

import com.nt.bindings.ActivateUser;
import com.nt.bindings.LoginCredentials;
import com.nt.bindings.RecoverPassword;
import com.nt.bindings.UserAccount;

public interface IUserMgmtService {
	public String registerUser(UserAccount user) throws Exception;
	public String activateUserAccount(ActivateUser user);
	public String login(LoginCredentials credentials);
	public List<UserAccount> listUsers();
	public UserAccount showUserByUserId(Integer id);
	public UserAccount showUserByEmailAndName(String email,String name);
	public String updateUser(UserAccount user);
	public String deleteUserById(Integer id);
	public String changeUserStatus(Integer id,String status);
	public String recoverPassword(RecoverPassword recover) throws Exception;
	

}
