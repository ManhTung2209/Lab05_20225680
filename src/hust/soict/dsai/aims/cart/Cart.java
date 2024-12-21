package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public boolean addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media item " + media.getTitle() + " has been added to the cart.");
            return true;
        } else {
            System.out.println("The media item " + media.getTitle() + " is already in the cart.");
            return false;
        }
    }

    public boolean removeMedia(String title) {
        Media media = searchByTitle(title);
        if (media != null) {
            itemsOrdered.remove(media);
            System.out.println("The media item " + media.getTitle() + " has been removed from the cart.");
            return true;
        } else {
            System.out.println("Media not found in the cart.");
            return false;
        }
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void filterCart() {
        System.out.print("Filter by (1) ID or (2) Title? ");
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
			int choice = scanner.nextInt();

			if (choice == 1) {
			    itemsOrdered.sort((m1, m2) -> Integer.compare(m1.getId(), m2.getId()));
			} else if (choice == 2) {
			    itemsOrdered.sort((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()));
			}
		}
		printCart();
    }

    public void sortCart() {
        System.out.print("Sort by (1) Title or (2) Cost? ");
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
			int choice = scanner.nextInt();

			if (choice == 1) {
			    itemsOrdered.sort((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()));
			} else if (choice == 2) {
			    itemsOrdered.sort((m1, m2) -> Float.compare(m1.getCost(), m2.getCost()));
			}
		}
		printCart();
    }

    public void printCart() {
        System.out.println("*********************** CART ***********************");
        int index = 1;
        for (Media media : itemsOrdered) {
            System.out.println(index + ". " + media.toString());
            index++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

	public void clearCart() {
		itemsOrdered.clear();
        System.out.println("The cart has been cleared.");
	}

	public ObservableList<Media> getItemsOrdered() {
		return FXCollections.observableArrayList(itemsOrdered);
	}
}
