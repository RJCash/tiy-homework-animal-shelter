import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rickiecashwell on 3/20/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        MenuService menu = new MenuService(scan);
        ArrayList<Animal> animal = new ArrayList<>();
        while(true){
            int selection = menu.getMenuAndSelection();
            if(selection == 1){
                menu.ListAnimal(animal);
            }else if(selection == 2){
                animal.add(menu.CreateAnAnimal());
            }else if(selection == 3){
                menu.viewAnimalDetails(animal);
            }else if(selection == 4){
                menu.editAnimal(animal);
            }else if(selection == 5){
                menu.deleteAnimal(animal);
            }else if(selection == 6){
               break;
            }

        }
    }
}
