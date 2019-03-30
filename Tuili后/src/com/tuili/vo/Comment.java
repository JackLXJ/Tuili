package com.tuili.vo;

public class Comment {
	private String content;
	private String user_name;
	private String user_image;
	private int comment_time;
	private String open_id;
	private int problem_id;
	
	public void setProblem_id(int problem_id) {
		this.problem_id = problem_id;
	}
	
	public int getProblem_id() {
		return problem_id;
	}
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_image() {
		return user_image;
	}
	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}
	public int getComment_time() {
		return comment_time;
	}
	public void setComment_time(int comment_time) {
		this.comment_time = comment_time;
	}
	public String getOpen_id() {
		return open_id;
	}
	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}

	
}
