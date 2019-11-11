package scaryterry.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import scaryterry.dtos.ImageRatingsDTO;
import scaryterry.models.Rating;
import scaryterry.repositories.RatingRepository;

@RestController
@RequestMapping("/images/{image-id}/ratings")
public class RatingImageController {

	@Autowired
	private RatingRepository ratingRepo;
	
	@GetMapping("")
	public ResponseEntity<ImageRatingsDTO> getRatings(
			@PathVariable("image-id") Integer imageId){
		return ResponseEntity.ok(new ImageRatingsDTO(ratingRepo.findByRatedImageId(imageId)));
	}
	
	@PostMapping("")
	public ResponseEntity<Rating> addRating(
			@RequestBody Rating rating,
			@PathVariable("image-id") Integer imageId){
		rating.setRatedImageId(imageId);
		Optional<Rating> oldRate = ratingRepo.findByRatedImageIdAndRatedById(imageId, rating.getRatedById());
		if(oldRate.isPresent())
			rating.setId(oldRate.get().getId());
		return ResponseEntity.ok(ratingRepo.save(rating));
	}
}
