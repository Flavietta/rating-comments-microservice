package scaryterry.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingRepository rateRepo;
	
	@Autowired
    private DiscoveryClient discoveryClient;
	
	@GetMapping("{id}")
	public ResponseEntity<Rating> getRate(@PathVariable Integer id){
		return ResponseEntity.ok(rateRepo.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<Rating> addRate(@RequestBody Rating rate){
		return ResponseEntity.ok(rateRepo.save(rate));
	}
	
}
