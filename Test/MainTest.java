import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
/**
 * Created by rickiecashwell on 3/28/17.
 */
public class MainTest {
    private ByteArrayOutputStream outputStream;
    @Before
    public void before() {
        this.outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }
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
    @Test
    public void editAnimal(){
        Animal animal= new Animal();
        Scanner scan = new Scanner("bear\nspecies\ngrizzly\n1");
        MenuService menu = new MenuService(scan);
        menu.CreateAnAnimal(animal);
        menu.viewAnimalDetails(animal);
        assertThat(outputStream.toString(), containsString("bear"));
        assertThat(outputStream.toString(), containsString("species"));
        assertThat(outputStream.toString(), containsString("grizzly"));
    }
}

