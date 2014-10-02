/**
 * 
 */
package org.jackho.sbJpaBlog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author jackho
 *
 */
@Entity
@Table(name="POST_PART")
public class PostPart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="POST_PART_ID")
	private Integer postPartId;
	
	@Column(name="BODY")
	private String body;
	
	@OneToOne
	@JoinColumn(name="POST_ID")
	private Post post;
	

	/**
	 * @return the postPartId
	 */
	public Integer getPostPartId() {
		return postPartId;
	}

	/**
	 * @param postPartId the postPartId to set
	 */
	public void setPostPartId(Integer postPartId) {
		this.postPartId = postPartId;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the post
	 */
	public Post getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
