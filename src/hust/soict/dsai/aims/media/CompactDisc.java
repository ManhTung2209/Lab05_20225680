package hust.soict.dsai.aims.media;

import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

	public String getArtist() {
		return artist;
	}


	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public boolean addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);	
			System.out.println("Track " + track +" has been added.");
			return true;
		} else {
			System.out.println("Track " + track +" is already exist.");
			return false;
		}
	}
	
	public boolean removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);	
			System.out.println("Track " + track +" has been removed.");
			return true;
		} else {
			System.out.println("Track " + track +" is not exist.");
			return false;
		}
	}
    
	public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
	
	 @Override
	    public void play() {
	        System.out.println("Playing Compact Disc: " + this.getTitle());
	        System.out.println("Artist: " + this.getArtist());
	        System.out.println("CD length: " + this.getLength());
	        System.out.println("Tracks:");
	        for (Track track : tracks) {
	            track.play();
	        }
	    }
}
