/**
 * 
 */
package org.jackho.sbJpaBlog;

import static org.junit.Assert.*;

import java.util.Date;

import org.jackho.sbJpaBlog.domain.Post;
import org.jackho.sbJpaBlog.domain.PostPart;
import org.jackho.sbJpaBlog.repository.PostPartRepository;
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
public class PostPartRepositoryTest {
	@Autowired
	PostPartRepository ppr;
	
	@Test
	public void test(){
		PostPart postPart = new PostPart();
		String body = "Hello";
		postPart.setBody(body);
		
		ppr.save(postPart);
		
		PostPart dbPostPart = ppr.findOne(postPart.getPostPartId());
		assertNotNull(dbPostPart);
		assertEquals(body,dbPostPart.getBody());
	}
	// test bidirectional -> PostPart has Post
	@Test
	public void insertTest(){
		Post post = new Post();
		post.setPostDate(new Date());
		post.setTitle("First post");
		
		PostPart postPart = new PostPart();
		String body = "Hello";
		postPart.setBody(body);
		
		postPart.setPost(post);
		
		ppr.save(postPart);
		
		PostPart dbpostPart = ppr.findOne(postPart.getPostPartId());
		assertNotNull(dbpostPart);
		assertNotNull(dbpostPart.getPost());
		assertEquals(body,dbpostPart.getBody());
	}
	

}
