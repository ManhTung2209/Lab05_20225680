package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public boolean addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("The media item " + media.getTitle() + " has been added to the store.");
            return true;
        } else {
            System.out.println("The media item " + media.getTitle() + " is already in the store.");
            return false;
        }
    }

    public boolean removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("The media item " + media.getTitle() + " has been removed from the store.");
            return true;
        } else {
            System.out.println("The media item " + media.getTitle() + " is not in the store.");
            return false;
        }
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void printStore() {
        System.out.println("*********************** STORE ***********************");
        int index = 1;
        for (Media media : itemsInStore) {
            System.out.println(index + ". " + media.toString());
            index++;
        }
        System.out.println("****************************************************");
    }
    
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore; 
    }
    
}
