package scaryterry.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import scaryterry.models.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer>{

	public List<Rating> findByRatedImageId(Integer id);
}
