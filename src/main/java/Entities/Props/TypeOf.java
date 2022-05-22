package Entities.Props;
import Entities.Book;

import java.util.List;
import java.util.Set;

public class TypeOf  {

    private String name;
    protected List<Set<Book>> books;


    public TypeOf(String name, List<Set<Book>> books) {
        this.name = name;
        this.books = books;
    }

    public TypeOf() {

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Set<Book>> getBooks() {
        return books;
    }

    public void setBooks( List<Set<Book>> books) {
        this.books = books;
    }

    public void afisare()
    {
        System.out.println("Gen: " + this.name);

    }

    public void afisareToateCartileDinTip()
    {
        System.out.println("Gen: " + this.name);
        for(Set<Book> books1: this.books) {
            for( Book book: books1){
                   book.afisare();
            }
            System.out.println("\n");
        }
    }
}
