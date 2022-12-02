
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SƠNPC
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Validation valid = new Validation();
        PhoneManager PM = new PhoneManager();
        System.out.println("Welcome to HKT Store - @ 2021 by <HE163264- Pham Minh Hai >");
        while (true) {
            System.out.println("Select the option below:\n"
                    + "1. Add a phone\n"
                    + "2. Search a phone by model\n"
                    + "3. Remove the phone by model\n"
                    + "4. Print the phone list in the descending order of Model\n"
                    + "5. Save data to file\n"
                    + "6. Quit");
            int choice = valid.getInt("Input your choice: ", "Please input a valid choice!", 1, 6);
            switch (choice) {
                case 1:
                    PM.addPhone();
                    break;
                case 2:
                    PM.searchByModel();
                    break;
                case 3:
                    PM.removeByModel();
                    break;
                case 4:
                    PM.sortByModel();
                    break;
                case 5:
                    PM.saveToFile();
                    break;
                case 6:
                    System.exit(0);
            }

        }
    }
}
