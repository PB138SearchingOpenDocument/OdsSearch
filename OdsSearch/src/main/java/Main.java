import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Marek Abaffy (422572), Marek Urban (422252)
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Configuring ODS module for default input file [products_small.ods] ...");

        String filePath = new String("products_small.ods");
        OdsSearch ods = new OdsSearch();
        ods.setup(filePath);

        try {
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(System.in));

            String userInput;
            String filePathConsole;

            System.out.println("Module is ready.");
            do {
                System.out.println("Enter search keyword or \n[!] - Exit\n[+] - Change input file");
                userInput = (String) br.readLine();
                if(userInput.equals("+")){
                    System.out.println("Enter new file path:");
                    filePathConsole = (String) br.readLine();
                    ods.setup(filePathConsole);
                }
                if(!userInput.equals("+") && !userInput.equals("!")){
                    ods.search(userInput);
                    ods.printResults();
                    ods.clearResults();
                }
            } while(!userInput.equals("!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
