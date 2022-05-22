import Entities.Autor;
import Entities.Book;
import Entities.Props.Genres;
import Entities.Props.PublishingHouse;
import Entities.Props.TypeOf;
import Entities.library.Member;
import Entities.library.Reader;
import Services.*;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        AuditService auditService = new AuditService();
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        MemberService memberService = new MemberService();
        AutorService autorService = new AutorService();
        PublishingHouseService publishingHouseService = new PublishingHouseService();

        Map<Integer, Book> books = bookService.getAllBooks();
        Map<Integer, Member> members = memberService.getAllMembers();
        Map<Integer, PublishingHouse> publishingHouses = (Map<Integer, PublishingHouse>) publishingHouseService.getAllPublishingHouses();
        Map<Integer, Autor> autors = (Map<Integer, Autor>) autorService.getAllAutors();


        List<Set<Book>> allbooks = new ArrayList<>();
        List<Book> typeOfBooksfictional = new ArrayList<>();
        List<Book> typeOfBooksNfictional = new ArrayList<>();

        Set<Book> booksPenelopeDouglas = new HashSet<>();
        PublishingHouse Trei = new PublishingHouse("Trei");
        Autor PenelopeDouglas = new Autor("PenelopeDouglas", booksPenelopeDouglas);
        Book Corrupt = new Book("Corrupt", PenelopeDouglas, Trei, 480, 13);
        booksPenelopeDouglas.add(Corrupt);
        allbooks.add(booksPenelopeDouglas);
        typeOfBooksfictional.add(Corrupt);
        TypeOf fictional = new TypeOf("fictional", allbooks);
        Genres Beletristica = new Genres("beletristica", typeOfBooksfictional);

        Set<Book> booksJenniferArmentrout = new HashSet<>();
        PublishingHouse Corint = new PublishingHouse("Corint");
        Autor JenniferArmentrout = new Autor("JenniferArmentrout", booksJenniferArmentrout);
        Book Obsidian = new Book("Obsidian", JenniferArmentrout, Corint, 200, 2);
        booksJenniferArmentrout.add(Obsidian);
        allbooks.add(booksJenniferArmentrout);
        typeOfBooksfictional.add(Obsidian);
        Genres Fantasy = new Genres("fantasy", typeOfBooksfictional);


        Set<Book> booksMathematics = new HashSet<>();
        PublishingHouse Paralela45 = new PublishingHouse("Paralela45");
        Autor ProfesoriDeMatematica = new Autor("ProfesoriDeMatematica", booksMathematics);
        Book Matematica = new Book("Matematica", ProfesoriDeMatematica, Paralela45, 180, 2);
        booksMathematics.add(Matematica);
        allbooks.add(booksMathematics);
        typeOfBooksNfictional.add(Corrupt);
        TypeOf nonFictional = new TypeOf("non-fictional", allbooks);
        Genres Manuale = new Genres("Manuale", typeOfBooksNfictional);


        List<Book> bookBorrowed = new ArrayList<Book>();
        bookBorrowed.add(Corrupt);
        bookBorrowed.add(Matematica);
        Book.setNumber(Book.getNumber() - 1);
        Book.setNumber(Book.getNumber() - 1);
        Member Marian = new Member("Marian", 1, bookBorrowed);

        Member Marta = new Member("Marta", 3, null);

        List<Book> allbookBorrowed2 = new ArrayList<Book>();
        List<Book> bookBorrowed2 = new ArrayList<Book>();
        bookBorrowed2.add(Obsidian);
        allbookBorrowed2.add(Obsidian);
        Obsidian.setNumber(Obsidian.getNumber() - 1);
        Reader Alex = new Reader("Alex", 2, allbookBorrowed2, bookBorrowed2);
        System.out.println();

        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("Meniu");
            System.out.println("1. Afisare ");
            System.out.println("2. Adaugare ");
            System.out.println("3. Update ");
            System.out.println("0. Exit");
            System.out.print("Alegerea ta: ");
            String option = scanner.nextLine();
            switch (option) {
                case "0": {
                    System.exit(0);
                }
                case "1": {
                    int ok = 1;
                    while (ok == 1) {
                        System.out.println();
                        System.out.println();
                        System.out.println("1. Afisare carti");
                        System.out.println("2.Afisare membri");
                        System.out.println("3.Afisare edituri");
                        System.out.println("4.Afisare autori");
                        System.out.println("0.Inapoi");
                        System.out.print("Alegerea ta: ");
                        String afisare = scanner.nextLine();
                        switch (afisare) {
                            case "0": {
                                ok = 0;
                                break;
                            }
                            case "1": {
                                for (Map.Entry<Integer, Book> me : books.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Afisare carti");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "2": {
                                for (Map.Entry<Integer, Member> me : members.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Afisare membri");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "3": {
                                for (Map.Entry<Integer, PublishingHouse> me : publishingHouses.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Afisare edituri");
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "4": {
                                for (Map.Entry<Integer, Autor> me : autors.entrySet()) {
                                    System.out.println(me.getKey() + ". " + me.getValue());
                                }
                                auditService.addAction("Afisare autori");
                                String aux = scanner.nextLine();
                                break;
                            }
                            default: {
                                System.out.println("Alegere invalida");
                            }
                            break;
                        }
                    }
                }
                case "2": {
                    int ok = 1;
                    while (ok == 1) {
                        System.out.println();
                        System.out.println();
                        System.out.println("1. Adauga carte");
                        System.out.println("2.Adauga membru");
                        System.out.println("3. Adauga editura");
                        System.out.println("4. Adauga autor");
                        System.out.println("0. Inapoi");
                        System.out.print("Alegerea ta: ");
                        String addOption = scanner.nextLine();
                        switch (addOption) {
                            case "0": {
                                ok = 0;
                                break;
                            }
                            case "1": {
                                bookService.addBook(bookService.AddBook());
                                auditService.addAction("Adauga carte");
                                books = (Map<Integer, Book>) bookService.getAllBooks();
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "2": {
                                memberService.addMember(memberService.AddMember());
                                auditService.addAction("Adauga membru");
                                members = (Map<Integer, Member>) memberService.getAllMembers();
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "3": {
                                publishingHouseService.addPublishingHouse(publishingHouseService.AddPublisingHouse());
                                auditService.addAction("Adauga editura");
                                publishingHouses = (Map<Integer, PublishingHouse>) publishingHouseService.getAllPublishingHouses();
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "4": {
                                autorService.addAutor(AutorService.AddAutor());
                                auditService.addAction("Adauga autor");
                                autors = (Map<Integer, Autor>) autorService.getAllAutors();
                                String aux = scanner.nextLine();
                                break;
                            }
                            default: {
                                System.out.println("Alegere invalida");
                            }
                        }
                    }
                    break;
                }
                case "3": {
                    int ok = 1;
                    while (ok == 1) {
                        System.out.println();
                        System.out.println();
                        System.out.println("1. Update carte");
                        System.out.println("2.Update membru");
                        System.out.println("3. Update editura");
                        System.out.println("4. Update autor");
                        System.out.println("0. Inapoi");
                        System.out.print("Alegerea ta: ");
                        String updateOption  = scanner.nextLine();
                        switch (updateOption ) {
                            case "0": {
                                ok = 0;
                                break;
                            }
                            case "1": {
                                bookService.updateBook(books, scanner);
                                auditService.addAction("Update carte");
                                books = (Map<Integer, Book>) bookService.getAllBooks();
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "2": {
                                memberService.updateMember(members, scanner);
                                auditService.addAction("Update member");
                                members = (Map<Integer, Member>) memberService.getAllMembers();
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "3": {
                                publishingHouseService.addPublishingHouse(publishingHouseService.AddPublisingHouse());
                                auditService.addAction("Adauga editura");
                                publishingHouses = (Map<Integer, PublishingHouse>) publishingHouseService.getAllPublishingHouses();
                                String aux = scanner.nextLine();
                                break;
                            }
                            case "4": {
                                autorService.updateAutor(autors, scanner);
                                auditService.addAction("Update autor");
                                autors = (Map<Integer, Autor>) autorService.getAllAutors();
                                String aux = scanner.nextLine();
                                break;
                            }
                            default: {
                                System.out.println("Alegere invalida");
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
}

