package scaryterry.dtos;

import java.util.List;
import java.util.stream.Collectors;


public class ImageRatingsDTO {

	public ImageRatingsDTO(List<scaryterry.models.Rating> ratings) {
		this.ratings = ratings.
				stream().
				map(r -> new Rating(r)).
				collect(Collectors.toList());
				
		this.imageId = ratings.get(0).getRatedImageId();
	}
	
	private Integer imageId;
	
	private List<Rating> ratings;

	public Integer getImageId() {
		return this.imageId;
	}
	
	public List<Rating> getRatings(){
		return this.ratings;
	}
	
	public Double getTotalRate() {
		return this.ratings.
				stream().
				mapToInt(Rating::getRate).
				average().
				orElse(Double.NaN);
	}
}

class Rating{

	public Rating(scaryterry.models.Rating rating){
		this.ratedById = rating.getRatedById();
		this.rate = rating.getRate();
		this.id = rating.getId();
	}
	
	private Integer ratedById;
	private Integer rate;
	private Integer id;
	
	public Integer getId() {
		return this.id;
	}
	
	public Integer getRate() {
		return this.rate;
	}
	public Integer getRatedById() {
		return this.ratedById;
	}
}


