/**
 * 
 */
package org.jackho.sbJpaBlog;

import static org.junit.Assert.*;

import java.util.Date;

import org.jackho.sbJpaBlog.domain.Comment;
import org.jackho.sbJpaBlog.domain.Post;
import org.jackho.sbJpaBlog.repository.CommentRepository;
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
public class CommentRepositoryTest {

	@Autowired
	CommentRepository cr ;
	
	@Test
	public void insertTest() {
		Post post = new Post();
		post.setPostDate(new Date());
		final String title = "This is a tutorial on one to many relationship";
		post.setTitle(title);
		
		Comment comment = new Comment();
		
		final String author = "Jack Mew";
		final String body = "This is a small comment";
		
		comment.setAuthor(author);
		comment.setBody(body);
		comment.setPost(post);
		
		cr.save(comment);
		
		Comment dbComment = cr.findOne(comment.getCommendId());
		assertNotNull(dbComment);
		assertNotNull(dbComment.getPost());
		assertEquals(author , dbComment.getAuthor());
		assertEquals(body , dbComment.getBody());
	}

}
