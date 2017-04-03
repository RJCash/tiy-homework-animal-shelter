import java.util.ArrayList;
/**
 * Created by rickiecashwell on 3/20/17.
 */
public class Animal {
    private ArrayList<String> animalList;
    private String species;
    private String Breed;

    public Animal(){
        animalList = new ArrayList<>();
    }
    public void setAnimalList(ArrayList<String> animalList) {
        this.animalList = animalList;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public void setBreed(String breed) {
        Breed = breed;
    }
    public ArrayList<String> getAnimals() {
        return this.animalList;
    }
    public void addAnimal(String name){
        this.animalList.add(name);
    }
    public String getSpecies() {
        return this.species;
    }
    public String getBreed(){
        return this.Breed;
    }
    public String toString() {
        return "Animal{" +
                "animalList=" + animalList +
                ", species='" + species + '\'' +
                '}';
    }
}