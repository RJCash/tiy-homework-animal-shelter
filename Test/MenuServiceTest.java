import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
    public void doesMenuServiceInstantiate(){
        Scanner scan = new Scanner(System.in);
        MenuService menu;
        if((menu = new MenuService(scan)) == null){
            fail();
        }
       assertThat("passed", equalTo("passed"));
    }
    @Test
    public void whenSelectionIs1Display() {
        String x = "1";
        Scanner scanner = new Scanner(x);
        MenuService menu = new MenuService(scanner);
        menu.getMenuAndSelection();
        assertThat(this.outputStream.toString(), containsString("-- Main Menu --"));
    }
    @Test
    public void whenSelectionIs2Display() {
        String x = "2";
        Scanner scanner = new Scanner(x);
        MenuService menu = new MenuService(scanner);
        menu.getMenuAndSelection();
        assertThat(this.outputStream.toString(), containsString("2) "));
    }
    @Test
    public void errorDisplay() {
        Scanner scanner = new Scanner("bad\n5");
        MenuService menu = new MenuService(scanner);
        int input = menu.getMenuAndSelection();
        assertThat(outputStream.toString(), containsString("bad is not a valid selection"));
    }
    @Test
    public void when1inputThenis1() {
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(1));
    }
    @Test
    public void when2inputThenis2() {
        Scanner scanner = new Scanner("2");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(2));
    }
    @Test
    public void when3inputThenis3() {
        Scanner scanner = new Scanner("3");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(3));
    }
    @Test
    public void when4inputThenis4() {
        Scanner scanner = new Scanner("4");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(4));
    }
    @Test
    public void when5inputThenis5() {
        Scanner scanner = new Scanner("5");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(5));
    }
    @Test
    public void when6inputThenis6() {
        Scanner scanner = new Scanner("6");
        MenuService menu = new MenuService(scanner);
        int selection = menu.getMenuAndSelection();
        assertThat(selection, equalTo(6));
    }
    @Test
    public void nothingToStart(){
        Animal animal = new Animal();
        Scanner scanner = new Scanner("1");
        MenuService menu = new MenuService(scanner);
        menu.getMenuAndSelection();
        System.out.println(animal.getAnimals());
        assertThat(outputStream.toString(), containsString("[]"));
    }
    @Test
    public void editAnimalThroughInput(){
        Animal animal= new Animal();
        Scanner scan = new Scanner("bear\nspecies\ngrizzly\n1");
        MenuService menu = new MenuService(scan);
        menu.CreateAnAnimal(animal);
        menu.viewAnimalDetails(animal);
        assertThat(outputStream.toString(), containsString("bear"));
        assertThat(outputStream.toString(), containsString("species"));
        assertThat(outputStream.toString(), containsString("grizzly"));
    }
    @Test
    public void deleteAnimalThroughInput(){
        Animal animal= new Animal();
        Scanner scan = new Scanner("bear\nspecies\ngrizzly\n1");
        MenuService menu = new MenuService(scan);
        menu.CreateAnAnimal(animal);
        menu.deleteAnimal(animal);
        assertThat(outputStream.toString(), containsString("bear has been removed"));
    }



}

