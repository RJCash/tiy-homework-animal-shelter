import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rickiecashwell on 3/20/17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        MenuService menu = new MenuService(scan);
        DriverManager.registerDriver(new org.postgresql.Driver());
        String jdbcUrl = "jdbc:postgresql://localhost/animalshelter";
        AnimalRepository repository = new AnimalRepository(jdbcUrl);
        ArrayList<Animal> animals = repository.listAnimalsIndatabase();
        //System.out.println(people);
        while(true){
            int selection = menu.getMenuAndSelection();
            if(selection == 1){
                menu.ListAnimal(animals);
            }else if(selection == 2){
                animals.add(menu.CreateAnAnimal());
            }else if(selection == 3){
                menu.viewAnimalDetails(animals);
            }else if(selection == 4){
                menu.editAnimal(animals);
            }else if(selection == 5){
                menu.deleteAnimal(animals);
            }else if(selection == 6){
                break;
            }
        }


    }
}