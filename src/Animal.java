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
        animalList.add("Stuffin");
        animalList.add("Pickles");
        animalList.add("Peggy");
    }
    public String setDefaultSpecies(String selection) throws Exception {
        if (selection.equals("Stuffin")) {
            this.species = "Bear";
            this.Breed = "Grizzly";
        }else
        if (selection.equals("Pickles")) {
            this.species = "Tiger";
            this.Breed = "White Tiger";
        }else
        if (selection.equals("Peggy")) {
            this.species = "Horse";
            this.Breed = "Donkey";
        }else{
           return this.species;
        }
        return this.species;
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
    public void addSpecies(String speciesName) throws Exception{
        this.species = speciesName;
    }
    public void addBreed(String breedName){
        this.Breed = breedName;
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