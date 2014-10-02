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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author jackho
 *
 */
@Entity
@Table(name="COMMENT")
public class Comment {
	
	@Id
	@Column(name="COMMENT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer commendId;
	
	@Column(name="AUTHOR")
	private String author;
	
	@Column(name="BODY")
	private String body;
	
	@ManyToOne
	@JoinColumn(name="POST_ID")
	private Post post;
	/**
	 * @return the commendId
	 */
	public Integer getCommendId() {
		return commendId;
	}
	/**
	 * @param commendId the commendId to set
	 */
	public void setCommendId(Integer commendId) {
		this.commendId = commendId;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result
				+ ((commendId == null) ? 0 : commendId.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (commendId == null) {
			if (other.commendId != null)
				return false;
		} else if (!commendId.equals(other.commendId))
			return false;
		return true;
	}
	
	
}
