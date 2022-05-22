package Services;

import Entities.Autor;
import Entities.Book;
import Repositories.AutorRepos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AutorService {

    private AutorRepos autorRepos;
    public void addAutor(Autor autor) {
        autorRepos.addAutor(autor);
        System.out.println("Autor adaugata");
    }

    public ArrayList<Autor> getAllAutors() {
        return (ArrayList<Autor>) autorRepos.getAllAutors();
    }

    public static Autor AddAutor() throws IOException {
        FileWriter writer;
        List<Autor> autors = new ArrayList<>();

        writer = new FileWriter("src/main/java/files/Autor.csv",true);
        ArrayList<String> continutFisier = new ArrayList<>();
        System.out.println("Nume: ");
        Scanner console = null;
        String nume = console.next();
        continutFisier.add(nume);
        Autor newAutor = new Autor(nume);

        writer.write(String.valueOf(continutFisier));
       autors.add(newAutor);
        return newAutor;
    }

    public void updateAutor(Map<Integer, Autor> autors, Scanner scanner) {
        System.out.println("Numele autorului");
        String name = scanner.nextLine();
        System.out.println("Noul nume");
        String nume = String.valueOf(scanner.nextLine());
        Autor autor1 = autors.get(name);
        AutorRepos.updateName(autor1, nume);
    }


}
