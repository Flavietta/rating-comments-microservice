package scaryterry.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer ratedById;
	
	private Integer ratedImageId;
	
	@Max(value = 5)
	@Min(value = 0)
	private Integer rate;

	public Integer getRatedById() {
		return ratedById;
	}

	public void setRatedById(Integer ratedById) {
		this.ratedById = ratedById;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Integer getId() {
		return id;
	}

	public Integer getRatedImageId() {
		return ratedImageId;
	}

	public void setRatedImageId(Integer ratedImageId) {
		this.ratedImageId = ratedImageId;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
