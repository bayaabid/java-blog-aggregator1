package sid.kaischaabane.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sid.kaischaabane.jpa.entity.Blog;
import sid.kaischaabane.jpa.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	public List<Item> findByBlog(Blog blog ,Pageable pageable);

}
