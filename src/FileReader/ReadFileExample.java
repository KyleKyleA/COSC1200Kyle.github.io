package FileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadFileExample {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("example.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

