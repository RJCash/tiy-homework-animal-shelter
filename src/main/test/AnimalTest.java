import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
/**
 * Created by rickiecashwell on 3/28/17.
 */
public class AnimalTest {
    private ByteArrayOutputStream outputStream;
    @Before
    public void before() {
        this.outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }
    @Test
    public void doesAnimalInstantiate(){
        Scanner scan = new Scanner(System.in);
        Animal animal;
        if((animal = new Animal("Donkey Kong","monkey","ape","likes bananas")) == null){
            fail();
        }
        assertThat("passed", equalTo("passed"));
    }
    @Test
    public void doesSetAnimalNameWork(){
        Animal animal = new Animal("fluffy","Husky","dog", "doggy");
        ArrayList<Animal> animals = new ArrayList<>();
        animal.setName("Bob");
        animals.add(animal);
        boolean hasAnimal = false;
        for(int i = 1; i <= animals.size(); i++){
            if(animals.get(i-1).getName() == "Bob"){
                hasAnimal = true;
            }
        }
        assertThat(true, equalTo(hasAnimal));
    }
    @Test
    public void addSpeciesWork() throws Exception{
        Animal animal = new Animal("fluffy","Husky","dog", "doggy");
        ArrayList<Animal> animals = new ArrayList<>();
        animal.setSpecies("someSpecies");
        animals.add(animal);
        boolean hasAnimal = false;
        for(int i = 1; i <= animals.size(); i++){
            if(animals.get(i-1).getSpecies() == "someSpecies"){
                hasAnimal = true;
            }
        }
        assertThat(true, equalTo(hasAnimal));
    }
    @Test
    public void addBreedWorks(){
        Animal animal = new Animal("fluffy","Husky","dog", "doggy");
        ArrayList<Animal> animals = new ArrayList<>();
        animal.setBreed("labrador");
        animals.add(animal);
        boolean hasAnimal = false;
        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).getBreed() == "labrador"){
                hasAnimal = true;
            }
        }
        assertThat(true, equalTo(hasAnimal));
    }
    @Test
    public void deleteAnimalInArrayList(){
        Animal animal = new Animal("fluffy","Husky","dog", "doggy");
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(animal);
        animals.remove(animal);
        assertThat(0, equalTo(animals.size()));
    }
    @Test
    public void addAnimalListWorks() {
        Animal animal = new Animal("Fluffy","was", "a", "bear");
        animal.setName("bear");
        System.out.println(animal.toString());
        assertThat(outputStream.toString(), containsString("bear"));
    }
}

