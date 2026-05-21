
package hust.soict.ite6.aims.media;


import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();

    public Media() {
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    @Override
    public String toString() {
        return String.format("Media - %s - %s - %.2f $", getTitle(), getCategory(), getCost());
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Media)) {
            return false;
        }

        Media other = (Media) o;
        return this.title.equals(other.title);
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public float getCost() {
        return cost;
    }
    
    public void setCost(float cost) {
        this.cost = cost;
    }
}