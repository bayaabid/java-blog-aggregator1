package sid.kaischaabane.jpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import sid.kaischaabane.jpa.entity.Blog;
import sid.kaischaabane.jpa.entity.Item;
import sid.kaischaabane.jpa.entity.User;
import sid.kaischaabane.jpa.repository.BlogRepository;
import sid.kaischaabane.jpa.repository.ItemRepository;
import sid.kaischaabane.jpa.repository.UserRepository;


@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository ;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findOne(int id) {
		
		return userRepository.findOne(id);
	}
	
	
	public User findOneWithBlog(int id) {
		User user = findOne(id) ;
		List<Blog> blogs=blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			
			List<Item> items = itemRepository.findByBlog(blog , new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
			
		}
		
		user.setBlogs(blogs);
		return user;
	}

	public  void save(User user) {
	
		userRepository.save(user);
	}

	

	

}
