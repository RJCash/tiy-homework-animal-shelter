import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by rickiecashwell on 3/20/17.
 */
public class MenuService {
    int selection = 0;
    Scanner scan;
    Animal animal;
    public MenuService(Scanner scan) {
        this.scan = scan;
    }
    public int getMenuAndSelection(){
        System.out.println("-- Main Menu --\n" +
                "\n" +
                "1) List animals\n" +
                "2) Create an animal\n" +
                "3) View animal details\n" +
                "4) Edit an animal\n" +
                "5) Delete an animal\n" +
                "6) Quit");
        return waitForInt("Please choose a number");
    }
    public int waitForInt(String message) {
        System.out.println(message);
        if (!scan.hasNextInt()) {
             String badMessage = scan.nextLine();
            System.out.println(badMessage + " is not a valid selection");
            return waitForInt(message);
        } else {
            return scan.nextInt();
        }
    }
    public String waitForString(String input, boolean status){
        System.out.println(input);
        input = scan.next();
        if(status == true && input.isEmpty()){
            System.out.println("This field requires input");
            return waitForString(input, status);
        }else{
            return input;
        }
    }
    public Animal CreateAnAnimal(Animal animal) {
        System.out.println(" -- Create an Animal -- ");
        System.out.println();
        try {
            while (true) {
                System.out.println("What is the animal name: ");
                String input = scan.nextLine();
                if (input.isEmpty()) {
                    System.out.print("Error: please enter a animal name\n");
                } else {
                    animal.addAnimal(input);
                    break;
                }
            }
            while (true) {
                System.out.print("What is the species: \n");
                String input = scan.nextLine();
                if (input.isEmpty()) {
                    System.out.print("Error: please enter a species\n");
                } else {
                    animal.addSpecies(input);
                    break;
                }
            }
            while (true) {
                System.out.println("What is the breed (optional): ");
                String input= scan.nextLine();
                if (input.isEmpty()) {
                    animal.addBreed(null);
                    break;
                } else {
                    animal.addBreed(input);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Enter a valid species");
        }
        return animal;
    }
    public Animal viewAnimalDetails(Animal animal) {
        ArrayList<String> animalList = animal.getAnimals();
        System.out.println("What is the numeric ID of the animal you want to view?: ");
        try {
            if (scan.hasNextInt()) {
                selection = scan.nextInt();
                for (int i = 1; i <= animalList.size(); i++) {
                    if (selection == i) {
                        System.out.println("Animal name is: " + animalList.get(i - 1));
                        System.out.println("Animal species is: "
                                + animal.getSpecies());
                        System.out.println("Animal breed is: " + animal.getBreed());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nInvalid data");
        }
        return animal;
    }




}