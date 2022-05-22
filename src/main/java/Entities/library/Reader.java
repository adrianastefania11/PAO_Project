package Entities.library;
import Entities.Book;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Member {


    protected static List<Book> booksRead;

    public Reader(String name, int id, List<Book> allBooksRead, List<Book> booksRead) {
        super(name, id, allBooksRead);
        if(booksRead == null) {
            this.booksRead = new ArrayList<>();
        } else {
            this.booksRead = booksRead;
        }

    }

    public static List<Book> getBooksRead() {
        return booksRead;
    }

    public static void setBooksRead(List<Book> booksRead) {
        Reader.booksRead = booksRead;
    }

    public void afisare() {
        super.afisare();
        if(!(booksRead == null)) {
            System.out.println("Carti imprumutate: ");
            for (Book book : this.booksRead) {
                book.afisare();
                System.out.println("\n");
            }
        } else {
            System.out.println("Nicio carte imprumutata.");
        }
    }

    public void imprumutaCarte (Book book) {
        if( getBooksRead().contains(book.getTitle())){
            System.out.println("Cartea  este deja imprumutata");
        } else if(book.getNumber() >= 1)  {
                List<Book> booksOnRead = getBooksRead();
                List<Book> allBooksRead = getAllBooksRead();
                booksOnRead.add(book);
                allBooksRead.add(book);
                setBooksRead(booksOnRead);
                setAllBooksRead(allBooksRead);
            book.setNumber(book.getNumber() - 1);
        } else {
            System.out.println("Cartea " + book.getTitle() + " nu este disponibila");
        }
    }

    public void returneazaCarte (Book book) {
        if(!getBooksRead().contains(book)) {
            System.out.println("Cartea  nu este pe lista de carti imprumutate de cititorul" +
             getName());
        } else {
            List<Book> booksOnRead = getBooksRead();
            booksOnRead.remove(book);
            setBooksRead(booksOnRead);
            System.out.println("Cartea a fost returnata.");
            book.setNumber(book.getNumber() + 1);
        }
    }
}
