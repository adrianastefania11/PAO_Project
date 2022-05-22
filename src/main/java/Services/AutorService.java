package Services;
import Entities.Autor;
import Repositories.AutorRepos;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AutorService {

    private AutorRepos autorRepos;
    public AutorService(){
        this.autorRepos= new AutorRepos();
    }
    public void addAutor(Autor autor) {
        autorRepos.addAutor(autor);
        System.out.println("Autor adaugata");
    }

    public Map<Integer, Autor> getAllAutors() {
        return autorRepos.getAllAutors();
    }

    public static Autor AddAutor() throws IOException {
        List<Autor> autors = new ArrayList<>();
        Scanner scanner = new Scanner(System. in);
        System.out.println("Nume: ");
        String nume = scanner.next();
        Autor newAutor = new Autor(nume);

        autors.add(newAutor);
        return newAutor;
    }
    public void deleteAutor(Map<Integer, Autor> autors, Scanner scanner) {
        System.out.println("Numele autorului:");
        String nume = scanner.nextLine();
        Autor autor = autors.get(nume);
        AutorRepos.deleteAutor(autor);
        System.out.println("Autor sters");
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
