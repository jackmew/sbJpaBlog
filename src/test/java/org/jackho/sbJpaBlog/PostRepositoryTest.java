/**
 * 
 */
package org.jackho.sbJpaBlog;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.jackho.sbJpaBlog.domain.Comment;
import org.jackho.sbJpaBlog.domain.Post;
import org.jackho.sbJpaBlog.domain.PostPart;
import org.jackho.sbJpaBlog.domain.Tag;
import org.jackho.sbJpaBlog.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author jackho
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional
public class PostRepositoryTest {
	
	@Autowired
	PostRepository pr;
	
	// test unidirectional -> Post has PostPart
	@Test
	public void test(){
		Comment comment1 = new Comment();
		Comment comment2 = new Comment();
		
		final String author1 = "Jack";
		final String author2 = "Chloe";
		final String body1 = "This is a test";
		final String body2 = "This is another test";
		
		comment1.setAuthor(author1);
		comment1.setBody(body1);
		
		comment2.setAuthor(author2);
		comment2.setBody(body2);
		
 		
		Post post = new Post();
		post.setPostDate(new Date());
		post.setTitle("First post");
		
		post.getComments().add(comment1);
		post.getComments().add(comment2);
		
		PostPart postPart = new PostPart();
		String body = "Hello";
		postPart.setBody(body);
		
		post.setPostPart(postPart);
		
		pr.save(post);
		
		Post dbpost = pr.findOne(post.getPostId());
		
		assertNotNull(dbpost);
		assertNotNull(dbpost.getPostPart());
		assertNotNull(dbpost.getComments());
		assertEquals(2,dbpost.getComments().size());
		
		List<Comment> comments = dbpost.getComments();
		
		assertTrue(comments.contains(comment1));
		assertTrue(comments.contains(comment2));
		
		System.out.println(dbpost.getTitle());
	}
	
	@Test
	public void testPost_Tag(){
		String tagName1 = "Java";
		String tagName2 = "Spring";
		
		Tag tag1 = new Tag();
		Tag tag2 = new Tag();
		
		tag1.setName(tagName1);
		tag2.setName(tagName2);
		
		Post post = new Post();
		post.setPostDate(new Date());
		post.setTitle("Second Post");
		
		post.getTags().add(tag1);
		post.getTags().add(tag2);
		
		pr.save(post);
		
		Post dbPost = pr.findOne(post.getPostId());
		
		assertNotNull(dbPost);
		
		List<Tag> tags = dbPost.getTags();
		
		assertTrue(tags.size() > 1);
		assertTrue(tags.contains(tag1));
		assertTrue(tags.contains(tag2));
	}


}
