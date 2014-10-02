/**
 * 
 */
package org.jackho.sbJpaBlog;

import static org.junit.Assert.*;

import org.jackho.sbJpaBlog.domain.Tag;
import org.jackho.sbJpaBlog.repository.TagRepository;
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
public class TagRepositoryTest {

	@Autowired
	TagRepository tr;
	
	@Test
	public void insertTest() {
		
		final String tagName = "Java";
		
		Tag tag = new Tag();
		tag.setName(tagName);
		
		tr.save(tag);
		
		Tag dbTag = tr.findOne(tag.getTagId());
		assertNotNull(dbTag);
		assertEquals(tagName , dbTag.getName());
	}

}
