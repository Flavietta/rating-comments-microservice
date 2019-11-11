package scaryterry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scaryterry.models.Comment;
import scaryterry.repositories.CommentsRepository;

@RestController
@RequestMapping("images/{image-id}/comments")
public class CommentImageController {

	@Autowired
	private CommentsRepository cr;
	
	@GetMapping
	public ResponseEntity<List<Comment>> getComments(
			@PathVariable("image-id") Integer imageId){
		return ResponseEntity.ok(cr.findByImageId(imageId));
	}
	
	@PostMapping
	public ResponseEntity<Comment> addComment(
			@PathVariable("image-id") Integer imageId,
			@RequestBody Comment comment){
		comment.setImageId(imageId);
		return ResponseEntity.status(HttpStatus.CREATED).body(cr.save(comment));
	}
	
}
