package hust.soict.ite6.aims.media;

import java.util.ArrayList;

public class Book extends Media {
    private ArrayList<String> authors = new ArrayList<>();

    public Book(){
        super();
    }
    
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    
    // --- CONSTRUCTOR MỚI ĐỂ PHỤC VỤ GIAO DIỆN ADD BOOK ---
    public Book(String title, String category, float cost, String authorList) {
        super(0, title, category, cost); // ID mặc định là 0
        this.addAuthor(authorList);    // Tự động thêm tác giả vào danh sách
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author added: " + authorName);
        } else {
            System.out.println("Author already exists.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author removed: " + authorName);
        } else {
            System.out.println("Author does not exist.");
        }
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory()
                + " - Authors: " + authors
                + " - Cost: " + getCost();
    }
}