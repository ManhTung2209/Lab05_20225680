package hust.soict.dsai.aims.Aims;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;

public class MediaPolymorphismDemo {
    public static void main(String[] args) {
        ArrayList<Media> mediaList = new ArrayList<>();

        
        mediaList.add(new DigitalVideoDisc(2, "Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f));
        mediaList.add(new CompactDisc(3, "Greatest Hits", "Music", 29.99f, 60, "Various Artists", "Queen"));

        
        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}
