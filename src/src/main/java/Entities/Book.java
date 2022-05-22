package Entities;
import Entities.Props.PublishingHouse;

public class Book {

    private String title;
    private Autor autor;

    private PublishingHouse publishingHouse;
    private static int isbn;
    private static int number;


    public Book(String title, Autor autor, PublishingHouse publishingHouse, int isbn, int number) {
        this.title = title;
        this.autor = autor;
        this.publishingHouse = publishingHouse;
        Book.isbn = isbn;
        Book.number = number;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public static int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        Book.isbn = isbn;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Book.number = number;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public void afisare(){
        System.out.println("Titlu: " + this.title);
        System.out.println("Autor: " + this.autor);
        System.out.println("ISBN" + this.isbn);
        System.out.println("Numar carti cu acest titlu" + this.number);
    }

    public void afisarecarteautor(){
        System.out.println("Titlu: " + this.title);
        System.out.println("ISBN" + this.isbn);
        System.out.println("Numar carti cu acest titlu" + this.number);

    }
}
