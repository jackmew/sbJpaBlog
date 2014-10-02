/**
 * 
 */
package org.jackho.sbJpaBlog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jackho
 *
 */
@RestController
public class PostController {

	@RequestMapping("/")
	public String init(){
		return "Bath";
	}
}

