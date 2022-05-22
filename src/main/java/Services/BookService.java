package Services;

import Entities.Autor;
import Entities.Book;
import Entities.Props.PublishingHouse;
import Entities.library.Member;
import Entities.library.Reader;
import Repositories.BookRepos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BookService {

    public BookRepos bookRepos;

    private static final List<Book> books = new ArrayList<>();
    private static final List<Reader> readers = new ArrayList<>();

    public BookService() {
        this.bookRepos = new BookRepos();
    }

    public void addBook(Book book) {
        bookRepos.addBook(book);
        System.out.println("Carte adaugata");
    }

    public Map<Integer, Book> getAllBooks() {
        return  bookRepos.getAllBooks();
    }



    public static void BorrowedBook(Scanner console) {


        for (Reader c : readers) {
            System.out.println(Member.getId());
        }
        System.out.println(" ID cititor : ");
        int idreader = console.nextInt();
        System.out.println(" ISBN-ul cartii: ");
        String isbn = console.next();
        for (Reader reader : readers) {
            if (Member.getId() == idreader) {
                for (Book book : books) {
                    if (Objects.equals(Book.getIsbn(), isbn) && Book.getNumber() >= 1) {
                        List<Book> booksReads = Reader.getBooksRead();
                        booksReads.add(book);
                        Book.setNumber(Book.getNumber() - 1);
                        Reader.setBooksRead(booksReads);
                        for (Book _book : Reader.getBooksRead()) {
                            _book.afisare();
                        }

                        break;
                    }
                }
                break;
            }
        }
    }

    public static void returnBook(Scanner console)  {

        System.out.println("Id: ");
        int idCititor = console.nextInt();
        System.out.println("Isbn: ");
        String isbn = console.next();
        for(Reader reader: readers) {
            if(Reader.getId() == idCititor) {
                for(Book book: books) {
                    if(Objects.equals(Book.getIsbn(), isbn) && Reader.getBooksRead().contains(book)) {
                        List<Book> booksborr= Reader.getBooksRead();
                        booksborr.remove(book);
                        Book.setNumber(Book.getNumber() + 1);
                        Reader.setBooksRead(booksborr);
                        break;
                    }
                }
                break;
            }
        }

    }


    public Book AddBook() throws IOException {
        FileWriter writer;
        writer = new FileWriter("src/main/java/files/Book.csv",true);
        ArrayList<String> continutFisier = new ArrayList<>();
        System.out.println("Titlu: ");
        Scanner console = null;
        String title = console.next();
        Autor autor = AutorService.AddAutor();
        String numeAutor = autor.getName();
        continutFisier.add(numeAutor);
        String nume = autor.getName();
        continutFisier.add(nume);
        PublishingHouse publishingHouse = PublishingHouseService.AddPublisingHouse();
        continutFisier.add(publishingHouse.getName());
        System.out.println("Isbn: ");
        int isbn = console.nextInt();
        continutFisier.add(String.valueOf(isbn));
        System.out.println("Exemplare : ");
        int numar = console.nextInt();
        continutFisier.add(String.valueOf(numar));
        Book newBook=new Book(title,autor,publishingHouse,isbn,numar);
        writer.write(String.valueOf(continutFisier));
        books.add(newBook);

        return newBook;
    }
    public void updateBook(Map<Integer, Book> book, Scanner scanner) {
        System.out.println("Numele cartii");
        String name = scanner.nextLine();
        System.out.println("Noul nume");
        int number = Integer.parseInt(scanner.nextLine());
        Book book1 = book.get(name);
        bookRepos.updateNumber(book1, number);
    }


}
