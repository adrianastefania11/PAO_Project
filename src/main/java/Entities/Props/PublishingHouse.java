package Entities.Props;

public class PublishingHouse {
    private String name;
    private int id;

    public PublishingHouse() {
    }

    public PublishingHouse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    void afisare()
    {
        System.out.println("Nume editura: " + this.name);
    }
}
