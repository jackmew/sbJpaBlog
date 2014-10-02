/**
 * 
 */
package org.jackho.sbJpaBlog.repository;

import org.jackho.sbJpaBlog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jackho
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
