package Services;
import Entities.Autor;
import Entities.Book;
import Entities.Props.PublishingHouse;
import Entities.library.Member;
import Entities.library.Reader;
import Repositories.BookRepos;
import java.util.Scanner;
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

    public void deleteBook(Map<Integer, Book> books, Scanner scanner) {
        System.out.println("Isbn:");
        String isbn = scanner.nextLine();
        Book book = books.get(Integer.parseInt(isbn));
        bookRepos.deleteBook(book);
        System.out.println("Carte stearsa");
    }


    public static void BorrowedBook(Scanner scanner) {


        for (Reader c : readers) {
            System.out.println(Member.getId());
        }
        System.out.println(" ID cititor : ");
        int idreader = Integer.parseInt(scanner.nextLine());
        System.out.println(" ISBN-ul cartii: ");
        String isbn = scanner.nextLine();
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

    public static void returnBook(Scanner scanner)  {

        System.out.println("Id: ");
        int idCititor = Integer.parseInt(scanner.nextLine());
        System.out.println("Isbn: ");
        String isbn = scanner.nextLine();
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
        Scanner scanner = new Scanner(System. in);;
        System.out.println("Titlu: ");
        String title = scanner.nextLine();
        Autor autor = AutorService.AddAutor();
        String numeAutor = autor.getName();
        String nume = autor.getName();
        PublishingHouse publishingHouse = PublishingHouseService.AddPublisingHouse();
        System.out.println("Isbn: ");
        int isbn = Integer.parseInt(scanner.nextLine());
        System.out.println("Exemplare : ");
        int numar = Integer.parseInt(scanner.nextLine());
        Book newBook=new Book(title,autor,publishingHouse,isbn,numar);
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
