package scaryterry.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import scaryterry.models.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer>{

	public List<Rating> findByRatedImageId(Integer id);
	public Optional<Rating> findByRatedImageIdAndRatedById(Integer ratedImageId,Integer ratedById);
}
