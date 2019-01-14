package dao;

import java.util.List;

public class Emp {
	
	
	private int id;
	private String name;
	private String password;

	private String textArea;
	
	private List<Feedh> feed;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getTextArea() {
		return textArea;
	}
	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}

	
	public List<Feedh> getFeed() {
		return feed;
	}
	public void setFeed(List<Feedh> feed2) {
		this.feed = feed2;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Emp() {
		super();
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", textArea=" + textArea + ", feed=" + feed + "]";
	}
	
}
