package Entities.library;

import Entities.Book;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private static int id;

    protected List<Book> AllBooksRead;

    public Member(String name, int id, List<Book> allBooksRead) {
        this.name = name;
        Member.id = id;
        this.AllBooksRead = allBooksRead;

    }

    public Member() {

    }

    public List<Book> getAllBooksRead() {
        return AllBooksRead;
    }

    public void setAllBooksRead(List<Book> allBooksRead) {
        this.AllBooksRead = allBooksRead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void afisare(){
        System.out.println("Nume membru: " + this.name);
        System.out.println("ID membru: " + this.id);
        if(!(AllBooksRead == null)) {
            System.out.println("Toate cartile care au fost imprumutate: ");
            for (Book book : this.AllBooksRead) {
                book.afisare();
                System.out.println("\n");
            }
        } else {
            System.out.println("Nicio carte imprumutata.");
        }
    }

    public void afisareSimpla(){
        System.out.println("Nume membru: " + this.name);
        System.out.println("ID membru: " + this.id);
    }
}
