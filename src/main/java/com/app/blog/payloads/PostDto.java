package com.app.blog.payloads;

import java.util.Date;

import com.app.blog.entities.Category;
import com.app.blog.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private String title;
	private String content;
	
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UserDto user;
	

}
