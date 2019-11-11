package scaryterry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scaryterry.models.Comment;
import scaryterry.repositories.CommentsRepository;

@RestController
@RequestMapping("comments")
public class CommentController {

	@Autowired
	private CommentsRepository cr;
	
	@GetMapping
	public ResponseEntity<List<Comment>> getComments(){
		return ResponseEntity.ok(cr.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Comment> getComment(@PathVariable Integer id){
		return ResponseEntity.ok(cr.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<Comment> addComment(
			@RequestBody Comment comment){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cr.save(comment));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Comment> deleteComment(@PathVariable Integer id){
		cr.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Comment> updateComment(
			@PathVariable Integer id,
			@RequestBody Comment comment){
		comment.setId(id);
		return ResponseEntity.ok(cr.save(comment));
	}
	
	
}
