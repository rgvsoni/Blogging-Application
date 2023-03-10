package com.app.blog.services;

import java.util.List;

import com.app.blog.entities.Post;
import com.app.blog.payloads.PostDto;

public interface PostService {
	
	// create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) ;
	
	// update 
	PostDto updatePost(PostDto postDto, Integer postId);
	
	// delete
	
	
	// get all posts
	
	List<PostDto> getAllPosts();
	void deletePost(Integer postId);
	
	// get Single post
	
	PostDto getPostById(Integer postId);
	
	// get posts by category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get posts by user
	
	List<PostDto> getPostsByUser(Integer userId);
	
	

}
