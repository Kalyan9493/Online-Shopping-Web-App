package com.omni.project.service;

import java.util.List;
import java.util.Optional;

import com.omni.project.entity.User;

public interface UserService {
	
	public void register(User user);

	public void deleteUser(Long id);

	public void updateUser(User user, Long id);

	public List<User> listUsers();

	public User getUser(Long id);

}
