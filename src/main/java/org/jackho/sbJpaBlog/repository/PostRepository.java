/**
 * 
 */
package org.jackho.sbJpaBlog.repository;

import org.jackho.sbJpaBlog.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jackho
 *
 */
public interface PostRepository extends JpaRepository<Post, Integer> {

}
