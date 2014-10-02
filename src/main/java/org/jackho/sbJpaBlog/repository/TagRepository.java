/**
 * 
 */
package org.jackho.sbJpaBlog.repository;

import org.jackho.sbJpaBlog.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jackho
 *
 */
public interface TagRepository extends JpaRepository<Tag, Integer> {

}
