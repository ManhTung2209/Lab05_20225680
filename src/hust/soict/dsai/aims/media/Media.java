package hust.soict.dsai.aims.media;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    
    
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Media)) {
            return false;
        }
        Media other = (Media) obj;
        return this.title != null && this.title.equals(other.title);
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s: %.2f $", title, category, id, cost);
    }
    

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
    
}
