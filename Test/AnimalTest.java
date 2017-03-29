import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
/**
 * Created by rickiecashwell on 3/28/17.
 */
public class AnimalTest {
    @Test
    public void doesAddAnimalWorks(){
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

}

