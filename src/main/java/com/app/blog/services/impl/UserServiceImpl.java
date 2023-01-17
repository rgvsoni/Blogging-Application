package com.app.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.exceptions.*;
import com.app.blog.entities.User;
import com.app.blog.payloads.UserDto;
import com.app.blog.repositories.UserRepo;
import com.app.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		
		User user = this.dtoTouser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userTodto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = userTodto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
		return this.userTodto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.userTodto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
		this.userRepo.delete(user);
		

	}
	
	private User dtoTouser(UserDto userdto) {
		User user = this.modelMapper.map(userdto, User.class);
		
		//user.setId(userdto.getId());
		//user.setName(userdto.getName());
		//user.setEmail(userdto.getEmail());
		//user.setAbout(userdto.getAbout());
		//user.setPassword(userdto.getPassword());
		
		return user;
	}
	public UserDto userTodto(User user) {
		UserDto userdto = this.modelMapper.map(user, UserDto.class);
		
		//userdto.setId(user.getId());
		//userdto.setName(user.getName());
		//userdto.setEmail(user.getEmail());
		//userdto.setAbout(user.getAbout());
		//userdto.setPassword(user.getPassword());
		
		return userdto;
	}
	
}
