package sid.kaischaabane.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sid.kaischaabane.jpa.entity.Blog;
import sid.kaischaabane.jpa.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	public List<Blog> findByUser(User user);

}
