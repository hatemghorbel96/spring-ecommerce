package com.example.produits.service;

import com.example.produits.entitys.Comment;


public interface CommentService {

	void addcomment(Long id,String username);
	Comment updateComment(Comment c);
	Comment saveComment(Comment c);
}
