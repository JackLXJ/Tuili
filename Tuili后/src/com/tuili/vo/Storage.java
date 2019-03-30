package com.tuili.vo;

public class Storage {
	
	private int zan_count;
	private int zan_status;
	private int collect_count;
	private int collect_status;
	private int comment_count;
	private int watch_count;
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	
	public int getZan_count() {
		return zan_count;
	}
	public void setZan_count(int zan_count) {
		this.zan_count = zan_count;
	}
	public int getZan_status() {
		return zan_status;
	}
	public void setZan_status(int zan_status) {
		this.zan_status = zan_status;
	}
	public int getCollect_count() {
		return collect_count;
	}
	public void setCollect_count(int collect_count) {
		this.collect_count = collect_count;
	}
	public int getCollect_status() {
		return collect_status;
	}
	public void setCollect_status(int collect_status) {
		this.collect_status = collect_status;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	public int getWatch_count() {
		return watch_count;
	}
	public void setWatch_count(int watch_count) {
		this.watch_count = watch_count;
	}


}
