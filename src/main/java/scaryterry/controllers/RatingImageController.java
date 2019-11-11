package scaryterry.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scaryterry.models.Rating;
import scaryterry.repositories.RatingRepository;

@RestController
@RequestMapping("/images/{image-id}/ratings")
public class RatingImageController {

	@Autowired
	private RatingRepository ratingRepo;
	
	@GetMapping("")
	public ResponseEntity<List<Rating>> getRatings(
			@PathVariable("image-id") Integer imageId){
		return ResponseEntity.ok(ratingRepo.findByRatedImageId(imageId));
	}
	
	@PostMapping("")
	public ResponseEntity<Rating> addRating(
			@RequestBody Rating rating,
			@PathVariable("image-id") Integer imageId){
		rating.setRatedImageId(imageId);
		return ResponseEntity.ok(ratingRepo.save(rating));
	}
}
