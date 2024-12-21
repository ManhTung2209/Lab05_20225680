package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(length, title, category, cost);
        this.length = length;
        this.director = director;
    }
    
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

	public void play() {
		// TODO Auto-generated method stub
		
	}
}

