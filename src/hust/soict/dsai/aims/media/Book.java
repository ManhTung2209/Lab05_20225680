package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	public Book(int id, String title, String category, List<String> authors, float cost) {
		super(id, title, category, cost);
	}
	
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	public boolean addAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("Author " + authorName +" has been added.");
			return true;
		} else {
			System.out.println("Author " + authorName +" is already exist.");
			return false;
		}
	}
	
	public boolean removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Author " + authorName +" has been removed.");
			return true;
		} else {
			System.out.println("Author " + authorName +" is not exist.");
			return false;
		}
	}
	
}
