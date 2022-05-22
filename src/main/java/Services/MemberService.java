package Services;

import Entities.Book;
import Entities.library.Member;
import Entities.library.Reader;

import Repositories.MemberRepos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MemberService {

    FileWriter writer;
    private MemberRepos memberRepos;

    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<Reader> readers = new ArrayList<>();


    public ArrayList<Member> GenerateReader (){
        ArrayList<Member> readers = new ArrayList<>();
        Member reader1= new Reader("Ana", 11, null, null);
        Member reader2= new Reader("Mihaela", 12,null,null);

        readers.add(reader1);
        readers.add(reader2);

        return readers;
    }

    public void addMember(Member member) {
        memberRepos.addMember(member);
        System.out.println("Membru adaugat");
    }

    public Map<Integer, Member> getAllMembers() {
        return  memberRepos.getAllMembers();
    }
    public Member AddMember() throws IOException {
        this.writer = new FileWriter("src/main/java/files/Member.csv",true);
        ArrayList<String> continutFisier = new ArrayList<>();
        System.out.println("Nume cititor: ");
        Scanner console = null;
        String name = console.next();
        continutFisier.add(name);
        System.out.println("ID cititor: ");
        int id = console.nextInt();
        continutFisier.add(Integer.toString(id));
        List<Book> allBooksRead = new ArrayList<>();

        Member newMember = new Member( name, id, allBooksRead);
        this.writer.write(String.valueOf(continutFisier));
        this.members.add(newMember);
        return newMember;
    }

    public void AddReader(Scanner console) throws IOException {
        this.writer = new FileWriter("src/main/java/files/Reader.csv",true);
        ArrayList<String> continutFisier = new ArrayList<>();
        System.out.println("Nume cititor: ");
        String nume = console.next();
        continutFisier.add(nume);
        System.out.println("ID cititor: ");
        int id = console.nextInt();
        continutFisier.add(Integer.toString(id));
        List<Book> allBooksRead = new ArrayList<>();
        List<Book> borrowedBooks = new ArrayList<>();

        Reader newReader = new Reader( nume, id, allBooksRead, borrowedBooks);
        this.writer.write(String.valueOf(continutFisier));
        this.readers.add(newReader);
    }

    public void updateMember(Map<Integer, Member> members, Scanner scanner) {
        System.out.println("Numele membrului");
        String name = scanner.nextLine();
        System.out.println("Noul nume");
        String nume = String.valueOf(scanner.nextLine());
        Member member1 = members.get(name);
        memberRepos.updateName(member1, nume);
    }

}
