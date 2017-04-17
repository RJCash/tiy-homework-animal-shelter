import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
/**
 * Created by rickiecashwell on 3/28/17.
 */
public class MenuServiceTest {
    private ByteArrayOutputStream outputStream;
    @Before
    public void before() {
        this.outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }
    @Test
    public void doesMenuServiceInstantiate() throws SQLException{
        Scanner scan = new Scanner(System.in);
        MenuService menu;
        if((menu = new MenuService(scan)) == null){
            fail();
        }
       assertThat("passed", equalTo("passed"));
    }
    @Test
    public void whenSelectionIs1Display() throws SQLException {
        String x = "1";
        Scanner scanner = new Scanner(x);
        MenuService menu = new MenuService(scanner);
        menu.getMenuAndSelection();
        assertThat(this.outputStream.toString(), containsString("-- Main Menu --"));
    }
    @Test
    public void whenSelectionIs2Display() throws SQLException {
        String x = "2";
        Scanner scanner = new Scanner(x);
        MenuService menu = new MenuService(scanner);
        menu.getMenuAndSelection();
        assertThat(this.outputStream.toString(), containsString("2) "));
    }
    @Test
    public void errorDisplay() throws SQLException {
        Scanner scanner = new Scanner("bad\n5");
        MenuService menu = new MenuService(scanner);
        int input = menu.getMenuAndSelection();
        assertThat(outputStream.toString(), containsString("bad is not a valid selection"));
    }
    @Test
    public void when1inputThenis1() throws SQLException {
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(1));
    }
    @Test
    public void when2inputThenis2()throws SQLException {
        Scanner scanner = new Scanner("2");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(2));
    }
    @Test
    public void when3inputThenis3()throws SQLException {
        Scanner scanner = new Scanner("3");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(3));
    }
    @Test
    public void when4inputThenis4()throws SQLException {
        Scanner scanner = new Scanner("4");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(4));
    }
    @Test
    public void when5inputThenis5() throws SQLException{
        Scanner scanner = new Scanner("5");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(5));
    }
    @Test
    public void when6inputThenis6()throws SQLException {
        Scanner scanner = new Scanner("6");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(6));
    }
    @Test
    public void nothingToStart()throws SQLException{
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);
        menu.getMenuAndSelection();
        menu.ListAnimal(animals);
        assertThat(outputStream.toString(), containsString("The shelter is empty"));
    }
    @Test
    public void CreateAnimalThroughInput()throws SQLException{
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scan = new Scanner("bear\nspecies\ngrizzly\ndescription\n1");
        MenuService menu = new MenuService(scan);
        animals.add(menu.CreateAnAnimal());
        menu.viewAnimalDetails(animals);
        assertThat(outputStream.toString(), containsString("bear"));
        assertThat(outputStream.toString(), containsString("species"));
        assertThat(outputStream.toString(), containsString("grizzly"));
    }
    @Test
    public void deleteAnimalThroughInput()throws SQLException{
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scan = new Scanner("bear\nspecies\ngrizzly\ndescription\n1");
        MenuService menu = new MenuService(scan);
        animals.add(menu.CreateAnAnimal());
        menu.deleteAnimal(animals);
        assertThat(outputStream.toString(), containsString("bear has been removed"));
    }
    @Test
    public void deleteAnimalThroughInputThatIsOutOfRange()throws SQLException{
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scan = new Scanner("bear\nspecies\ngrizzly\nDescription\n5\n24");
        MenuService menu = new MenuService(scan);
        animals.add(menu.CreateAnAnimal());
        menu.deleteAnimal(animals);
        assertThat(outputStream.toString(), containsString("Please choose a valid range"));
    }
    @Test
    public void deleteAnimalInAEmptyShelter()throws SQLException{
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scan = new Scanner("5");
        MenuService menu = new MenuService(scan);
        menu.deleteAnimal(animals);
        assertThat(outputStream.toString(), containsString("Shelter is empty"));
    }
    @Test
    public void selectionQuitTest() throws SQLException{
        String input = "6";
        Scanner scan = new Scanner(input);
        MenuService menu = new MenuService(scan);
        Main main = new Main();
        assertThat(Integer.parseInt(input), equalTo(menu.getMenuAndSelection()));
    }
    @Test
    public void CheckAnimalName() throws SQLException{
            Animal animal = new Animal("fluffy","Husky","dog", "doggy");
            ArrayList<Animal> animals = new ArrayList<>();
            Scanner scanner = new Scanner("1");
            MenuService menu = new MenuService(scanner);
            animals.add(animal);
            menu.ListAnimal(animals);
            assertThat(outputStream.toString(), containsString("fluffy"));
        }
        @Test
        public void promptForViewDetailsID()throws SQLException{
            Animal animal = new Animal("fluffy","Husky","dog", "doggy");
            ArrayList<Animal> animals = new ArrayList<>();
            Scanner scanner = new Scanner("1");
            MenuService menu = new MenuService(scanner);
            animals.add(animal);
            menu.viewAnimalDetails(animals);
            assertThat(outputStream.toString(), containsString("What is the numeric ID"));
        }
        @Test
        public void viewDetails() throws SQLException{
            Animal animal = new Animal("fluffy","Husky","dog", "doggy");
            ArrayList<Animal> animals = new ArrayList<>();
            animals.add(animal);
            Scanner scanner = new Scanner("1");
            MenuService menu = new MenuService(scanner);
            menu.viewAnimalDetails(animals);
            assertThat(outputStream.toString(), containsString("fluffy"));
            assertThat(outputStream.toString(), containsString("Husky"));
            assertThat(outputStream.toString(), containsString("dog"));
    }
    @Test
    public void editAnimalThroughInput()throws SQLException{
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scan = new Scanner("bear\nspecies\ngrizzly\nDescription\n1\nRickie\nHuman\nman\ncool\n3\n0");
        MenuService menu = new MenuService(scan);
        animals.add(menu.CreateAnAnimal());
        menu.editAnimal(animals);
        System.out.println(animals);
        assertThat(outputStream.toString(), containsString("Rickie"));
        assertThat(outputStream.toString(), containsString("Human"));
        assertThat(outputStream.toString(), containsString("man"));
    }
    @Test
    public void PromptForEditAnimalID()throws SQLException{
        ArrayList<Animal> animals = new ArrayList<>();
        Scanner scan = new Scanner("bear\nspecies\ngrizzly\nDescription\n4");
        MenuService menu = new MenuService(scan);
        animals.add(menu.CreateAnAnimal());
        menu.editAnimal(animals);
        assertThat(outputStream.toString(), containsString("What is the " +
                "numeric ID"));
    }
}


