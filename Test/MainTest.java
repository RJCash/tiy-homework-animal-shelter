import org.junit.Test;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
/**
 * Created by rickiecashwell on 3/28/17.
 */
public class MainTest {
    @Test
    public void selectionQuitTest() {
        String input = "6";
        Scanner scan = new Scanner(input);
        MenuService menu = new MenuService(scan);
        Main main = new Main();
        assertThat(Integer.parseInt(input), equalTo(menu.getMenuAndSelection()));
    }
        @Test
    public void addBreedWorks(){
        Animal animal = new Animal();
        animal.addBreed("labrador");
        System.out.println(animal.getBreed());
        assertThat(animal.getBreed(), containsString("labrador"));
    }
    }

