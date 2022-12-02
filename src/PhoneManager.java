
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SƠNPC
 */
public class PhoneManager {

    private List<Phone> listPhone = new ArrayList<>();

    void addPhone() {

        while (true) {
            String model = Validation.getString("Enter the phone model you want to add: ", "Please input a valid model!", "^[a-zA-Z0-9 ]+$");
            if (FindPhonebyModel(model) != null) {
                System.out.println("Duplicate model, please enter another model!");
                continue;
            }
            String CPU = Validation.getString("Enter CPU of the phone you want to add: ", "Please enter a valid CPU!", "^[a-zA-Z0-9 ]+$");
            String RAM = Validation.getString("Enter RAM of the phone you want to add: ", "Please enter a valid RAM!", "^[a-zA-Z0-9 ]+$");
            String primaryCam = Validation.getString("Enter primary camera of the phone you want to add: ", "Please enter a valid primary camera!", "^[a-zA-Z0-9 ]+$");
            String screenSize = Validation.getString("Enter screen size of the phone you want to add: ", "Please enter a valid screen size!", "^[a-zA-Z0-9 ]+$");
            double price = Validation.getDouble("Enter price of the phone you want to add: ", "Please enter a valid price!", 0, Double.MAX_VALUE);
            String color = Validation.getString("Enter color of the phone you want to add: ", "Please enter a valid color!", "^[a-zA-Z ]+$");
            String brand = Validation.getString("Enter brand of the phone you want to add: ", "Please enter a valid brand!", "^[a-zA-Z ]+$");
            Phone phone = new Phone(model, CPU, RAM, primaryCam, screenSize, color, brand, price);
            listPhone.add(phone);
            String choice = Validation.getString("Do you want to add more phone?", "Please enter yes or no!", "^[yes|no]+$");
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Adding the next phone...");
            } else {
                break;
            }
        }
        System.out.println("The list after adding is:");
        printList();

    }

    private Phone FindPhonebyModel(String model) {
        for (Phone phone : listPhone) {
            if (phone.getModel().equalsIgnoreCase(model)) {
                return phone;
            }
        }
        return null;
    }

    void searchByModel() {
        while (true) {
            String model = Validation.getString("Enter the model you want to search for:", "Please enter a valid model!", "^[a-zA-Z0-9 ]+$");
            boolean isExisted = false;
            for (Phone phone : listPhone) {
                if (phone.getModel().contains(model)) {
                    if (!isExisted) {
                        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                                "Model", "CPU", "RAM", "Primary CAM", "Screen size", "Color", "Brand", "Price");
                    }
                    isExisted = true;
                    System.out.println(phone);
                }
            }
            if (!isExisted) {
                System.out.println("This phone Model does not exist!");
            }
            String choice = Validation.getString("Do you want to continue searching?", "Please enter yes or no!", "^[yes|no]+$");
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Continue searching...");
            } else {
                break;
            }
        }
    }

    void removeByModel() {
        while (true) {
            String model = Validation.getString("Enter the model you want to remove:", "Please enter a valid model!", "^[a-zA-Z0-9 ]+$");
            if (FindPhonebyModel(model) != null) {
                Phone phone = FindPhonebyModel(model);
                System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                        "Model", "CPU", "RAM", "Primary CAM", "Screen size", "Color", "Brand", "Price");
                System.out.println(phone);
                String choice = Validation.getString("Do you want to delete this model?", "Please enter yes or no!", "^[yes|no]+$");
                if (choice.equalsIgnoreCase("yes")) {
                    listPhone.remove(phone);
                    System.out.println("Deleted model successfully!");
                } else {
                    System.out.println("Deleted unsuccessfully!");
                }
            } else {
                System.out.println("Model not found!");              
            }
            String choice = Validation.getString("Do you want to continue deleting?", "Please enter yes or no!", "^[yes|no]+$");
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Continue Deleting...");
            } else {
                break;
            }
        }
        System.out.println("The list phone after finished deleting is:");
        printList();
    }

    void sortByModel() {
        Collections.sort(listPhone, new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                return o1.getModel().compareTo(o2.getModel());
            }
        });
        System.out.println("The list after sort by model is:");
        printList();
    }

    void printList() {
        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                "Model", "CPU", "RAM", "Primary CAM", "Screen size", "Color", "Brand", "Price");
        for (Phone phone : listPhone) {
            System.out.println(phone);
        }
    }

    void saveToFile() throws IOException {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            String fileName = Validation.getString("Enter the file name you want to add:", "Please enter a valid file name!", "^[a-zA-Z0-9 ]+$");
            File f = new File(fileName);
            if (!f.exists()) {
                f.createNewFile();
            }
            fw = new FileWriter(fileName, true);
            bw = new BufferedWriter(fw);
            bw.write(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                    "Model", "CPU", "RAM", "Primary CAM", "Screen size", "Color", "Brand", "Price"));
            for (Phone phone : listPhone) {
                bw.write(phone.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Saved successfully!");
        } catch (IOException e) {
        }
    }
}
