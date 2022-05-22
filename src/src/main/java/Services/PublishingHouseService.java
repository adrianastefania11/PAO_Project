package Services;
import Entities.Props.PublishingHouse;
import Repositories.PublishingHouseRepos;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PublishingHouseService {

    private static final List<PublishingHouse> publishingHouses = new ArrayList<>();

    private PublishingHouseRepos publishingHouseRepos;
    public PublishingHouseService() {
        this.publishingHouseRepos= new PublishingHouseRepos();
    }
    public void addPublishingHouse(PublishingHouse publishingHouse) {
        publishingHouseRepos.addPublishingHouse(publishingHouse);
        System.out.println("Editura adaugata");
    }

    public Map<Integer, PublishingHouse> getAllPublishingHouses() {
        return  publishingHouseRepos.getAllPublisingHouses();
    }

    public void deletePublishingHouse(Map<Integer, PublishingHouse> publishingHouses, Scanner scanner) {
        System.out.println("Numele editurii:");
        String nume = scanner.nextLine();
        PublishingHouse publishingHouse = publishingHouses.get(nume);
        PublishingHouseRepos.deletePublishingHouse(publishingHouse);
        System.out.println("Editura stearsa");
    }


    public static PublishingHouse AddPublisingHouse() throws IOException {
        Scanner scanner = new Scanner(System. in);
        System.out.println("Editura: ");
        String nume = scanner.next();
        PublishingHouse newPublishingHouse = new PublishingHouse(nume);
        publishingHouses.add(newPublishingHouse);

        return newPublishingHouse ;
    }

    public void updatePublishingHouse(Map<Integer, PublishingHouse> publishingHouses, Scanner scanner) {
        System.out.println("Numele membrului");
        String name = scanner.nextLine();
        System.out.println("Noul nume");
        String nume = String.valueOf(scanner.nextLine());
        PublishingHouse publishingHouse1 = publishingHouses.get(name);
        publishingHouseRepos.updateName(publishingHouse1, nume);
    }


}
