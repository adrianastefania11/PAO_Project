package Entities.library;
import java.util.ArrayList;
import java.util.List;

public class Librarian {
    private String name;
    protected List<Member> members;

    public Librarian(String name, List<Member> members) {
        this.name = name;
        if(members == null) {
            this.members = new ArrayList<>();
        } else {
            this.members = members;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        members = members;
    }
}
