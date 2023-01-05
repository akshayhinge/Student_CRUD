package com.student_crud.mvc.entities;

import java.util.List;


public class ResultWrapper {

private int page;
	
	private List<Student> result;
	
	private int total_pages;
	
	private long total_results;
	
	public ResultWrapper() {}

	public ResultWrapper(int page, List<Student> result, int total_pages, long total_results) {
		super();
		this.page = page;
		this.result = result;
		this.total_pages = total_pages;
		this.total_results = total_results;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Student> getResult() {
		return result;
	}

	public void setResult(List<Student> result) {
		this.result = result;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public long getTotal_results() {
		return total_results;
	}

	public void setTotal_results(long total_results) {
		this.total_results = total_results;
	}
	
}
