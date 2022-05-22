package Entities;
import java.util.HashSet;
import java.util.Set;

public class Autor {

    private int id;
    private String name;
    private  Set<Book> books;

    public Autor(String name) {
        this.name = name;
    }

    public Autor(String name, Set<Book> books) {
        this.name = name;
        if(books == null) {
            this.books = new HashSet<Book>();
        } else {
            this.books = books;
        }
    }

    public Autor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void afisare(){
        System.out.println("Nume: " + this.name);
        System.out.println("Cartile autorului: \n");
        for(Book book: this.books) {
            book.afisarecarteautor();
            System.out.println("\n");
        }
    }

    public void afiarenume(){
        System.out.println("Nume: " + this.name);

    }


}
