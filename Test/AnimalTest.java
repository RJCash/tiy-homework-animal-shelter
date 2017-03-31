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
        if((animal = new Animal()) == null){
            fail();
        }
        assertThat("passed", equalTo("passed"));
    }
    @Test
    public void doesAddAnimalWork(){
        Animal animal = new Animal();
        animal.addAnimal("Monkey");
        boolean hasAnimal = false;
        for(int i = 1; i <= animal.getAnimals().size(); i++){
            if(animal.getAnimals().get(i-1) == "Monkey"){
                hasAnimal = true;
            }
        }
        assertThat(true, equalTo(hasAnimal));
    }
    @Test
    public void addSpeciesWork() throws Exception{
        Animal animal = new Animal();
        animal.addSpecies("someSpecies");
        System.out.println(animal.getSpecies());
        assertThat(animal.getSpecies(), containsString("someSpecies"));
    }
    @Test
    public void addBreedWorks(){
        Animal animal = new Animal();
        animal.addBreed("labrador");
        System.out.println(animal.getBreed());
        assertThat(animal.getBreed(), containsString("labrador"));
    }
    @Test
    public void deleteAnimalInArrayList(){
        Animal animal = new Animal();
        animal.getAnimals().add("gorilla");
        animal.getAnimals().remove(0);
        assertThat(0, equalTo(animal.getAnimals().size()));
    }
    @Test
    public void addAnimalListWorks() {
        Animal animals = new Animal();
        animals.addAnimal("bear");
        System.out.println(animals.getAnimals());
        assertThat(outputStream.toString(), containsString("bear"));
    }
}

