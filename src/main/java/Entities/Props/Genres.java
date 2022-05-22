package Entities.Props;
import Entities.Book;
import java.util.List;
import java.util.Set;

public class Genres extends TypeOf {

    private String genName;
    private List<Book> genbooks;

    public Genres(String genName, List<Book> genbooks) {
        super();
        this.genName = genName;
        this.genbooks = genbooks;
    }

    public Genres(String name, List<Set<Book>> books, String genName,  List<Book> genbooks){
        super(name, books);
        this.genName = genName;
        this.genbooks = genbooks;
    }



    public String getGenName() {
        return genName;
    }

    public void setGenName(String genName) {
        this.genName = genName;
    }

    public  List<Book> getGenbooks() {
        return genbooks;
    }

    public void setGenbooks( List<Book> genbooks) {
        this.genbooks = genbooks;
    }

    public void afisare(){
        super.afisare();
        System.out.println("Subsectiune: " + this.genName);
        for(Book book: this.genbooks) {
            book.afisare();
            System.out.println("\n");
        }

    }
}
