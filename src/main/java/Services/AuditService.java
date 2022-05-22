package Services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditService
{
    FileWriter writer;


    public AuditService() {
        try {
            File dir = new File("src/main/java/files");
            File file = new File("src/main/java/files/history.csv");
            this.writer = new FileWriter("src/main/java/files/history.csv",true);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addAction(String action) throws IOException {
        this.writer = new FileWriter("src/main/java/files/history.csv",true);
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.writer.write((action + ','+ timestamp + '\n'));
        this.writer.close();
    }

}
