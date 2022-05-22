package Services;

import Entities.Props.PublishingHouse;
import Entities.library.Member;
import Repositories.PublishingHouseRepos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PublishingHouseService {

    private static final List<PublishingHouse> publishingHouses = new ArrayList<>();

    private PublishingHouseRepos publishingHouseRepos;
    public void addPublishingHouse(PublishingHouse publishingHouse) {
        publishingHouseRepos.addPublishingHouse(publishingHouse);
        System.out.println("Editura adaugata");
    }

    public ArrayList<PublishingHouse> getAllPublishingHouses() {
        return (ArrayList<PublishingHouse>) publishingHouseRepos.getAllPublisingHouses();
    }


    public static PublishingHouse AddPublisingHouse() throws IOException {
        FileWriter writer;
        writer = new FileWriter("src/main/java/files/PublishingHouse.csv",true);

        ArrayList<String> continutFisier = new ArrayList<>();
        System.out.println("Editura: ");
        Scanner console = null;
        String nume = console.next();
        continutFisier.add(nume);
        PublishingHouse newPublishingHouse = new PublishingHouse(nume);
        writer.write(String.valueOf(continutFisier));
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
