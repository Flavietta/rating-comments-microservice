package scaryterry.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import scaryterry.models.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Integer>{

	public List<Comment> findByImageId(Integer id);
}
