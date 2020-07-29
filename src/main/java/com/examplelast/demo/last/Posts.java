package com.examplelast.demo.last;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity	
public class Posts {

	  @Id
	  // @GeneratedValue(strategy=GenerationType.AUTO)
	   private Long id;

	   private String title;

	   private String body;

	   
	public Posts(Long id, String title, String body) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Posts [id=" + id + ", title=" + title + ", body=" + body + "]";
	}
	
}
