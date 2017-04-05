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
    public void ListAnimal(ArrayList<Animal> animal){
        if(animal.size() == 0) {
            System.out.println("The shelter is empty");
        }
        for(int i = 0; i < animal.size(); i++){
            System.out.println((i+1)+")"+animal.get(i).getName()+"       "+ animal.get(i).getSpecies());
        }

    }
    public Animal CreateAnAnimal() {
        System.out.println(" -- Create an Animal -- ");
        System.out.println();
        Animal animal = new Animal("x","x","x","x");
        try {
            while (true) {
                System.out.println("What is the animal name: ");
                String input = scan.nextLine();
                if (input.isEmpty()) {
                    System.out.print("Error: please enter a animal name\n");
                } else {
                    animal.setName(input);
                    break;
                }
            }
            while (true) {
                System.out.print("What is the species: \n");
                String input = scan.nextLine();
                if (input.isEmpty()) {
                    System.out.print("Error: please enter a species\n");
                } else {
                    animal.setSpecies(input);
                    break;
                }
            }
            while (true) {
                System.out.println("What is the breed (optional): ");
                String input= scan.nextLine();
                if (input.isEmpty()) {
                    animal.setBreed(null);
                    break;
                } else {
                    animal.setBreed(input);
                    break;
                }
            }
            while (true) {
                System.out.println("What is the description: ");
                String input= scan.nextLine();
                if (input.isEmpty()) {
                    animal.setDescription(null);
                    break;
                } else {
                    animal.setDescription(input);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Enter a valid species");
        }
        return animal;
    }

    public ArrayList<Animal> viewAnimalDetails(ArrayList<Animal> animal) {
        if(animal.size() ==  0){
            System.out.println("The shelter is empty");
        }else {
            System.out.println("What is the numeric ID of the animal you want to view?: ");
            if(selection > animal.size() || selection < 0){
                System.out.println("Pick a valid range");
            }else {
                try {
                    if (scan.hasNextInt()) {
                        selection = scan.nextInt();
                        for (int i = 1; i <= animal.size(); i++) {
                            if (selection == i) {
                                System.out.println("Animal name is: " + animal.get(i - 1).getName());
                                System.out.println("Animal species is: "
                                        + (animal.get(i - 1).getSpecies()));
                                if(animal.get(i-1).getBreed()==null) {
                                    System.out.println("Animal breed is: " + "N/A");
                                }else{
                                    System.out.println("Animal breed is: " + animal.get(i - 1).getBreed());
                                }
                                System.out.println("Animal description is: " + animal.get(i - 1).getDescription());
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println("\nInvalid data");
                }
            }
        }
        return animal;
    }
    public ArrayList<Animal> editAnimal(ArrayList<Animal> animal) {
        System.out.println();
        if(animal.size() ==  0){
            System.out.println("The shelter is empty");
        }else {
            int selection = waitForInt("What is the numeric ID of the animal you want to edit?");
            if(selection > animal.size() || selection < 0){
                System.out.println("Pick a valid range");
            }else {
                for (int i = 1; i <= animal.size(); i++) {
                    if (selection == i) {
                        System.out.println("The animal you chose is: ");
                        System.out.println(animal.get(i - 1).getName());
                        while (true) {
                            System.out.println("What is the new name: ");
                            String input = scan.nextLine();
                            if (input.isEmpty()) {
                                System.out.println("You didn't change name.");
                                break;
                            } else {
                                animal.get(i - 1).setName(input);
                                break;
                            }
                        }
                        try {
                            while (true) {
                                System.out.println("What is the new species: ");
                                String input = scan.nextLine();
                                if (input.isEmpty()) {
                                    System.out.println("You didn't change species.");
                                    break;
                                } else {
                                    animal.get(i - 1).setSpecies(input);
                                    break;
                                }
                            }
                            while (true) {
                                System.out.println("What is the new description: ");
                                String input = scan.nextLine();
                                if (input.isEmpty()) {
                                    System.out.println("You didn't change description");
                                    break;
                                } else {
                                    animal.get(i - 1).setDescription(input);
                                    break;
                                }
                            }
                            while (true) {
                                System.out.println("What is the new breed(optional): ");
                                String input = scan.nextLine();
                                if (input.isEmpty()) {
                                    animal.get(i - 1).setBreed("N/A");
                                    System.out.println("You didn't change breed");
                                    break;
                                } else {
                                    animal.get(i - 1).setBreed(input);
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Error");
                        }
                    }

                }
            }
        }
        return animal;
    }
    public ArrayList<Animal> deleteAnimal(ArrayList<Animal> animals) {
        int selection = waitForInt("What is the numeric ID of the animal you want to delete?: ");
        try {
            for (int i = 0; i <= animals.size(); i++) {
                if (selection == i) {
                    System.out.println( animals.get(i-1).getName()+ " has been removed");
                    animals.remove(i - 1);
                }
                if(animals.size() == 0){
                    System.out.println("Shelter is empty");
                }
            }
            if(selection > animals.size() || selection < 0) {
                System.out.println("Please choose a valid range");
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return animals;
    }

}