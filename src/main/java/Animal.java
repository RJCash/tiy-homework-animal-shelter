/**
 * Created by rickiecashwell on 3/20/17.
 */
public class Animal {
    private String name;
    private String species;
    private String Breed;
    private String description;
    private int ID;

    public Animal(String name, String species, String breed, String description){
        this.name = name;
        this.species = species;
        this.Breed = breed;
        this.description = description;
    }
    public Animal(int id, String name,String species, String breed, String description) {
        this.name = name;
        this.species = species;
        this.Breed = breed;
        this.description = description;
        this.ID = id;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBreed(String breed) {
        Breed = breed;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getSpecies() {
        return species;
    }
    public String getBreed() {
        return Breed;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", Breed='" + Breed + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}