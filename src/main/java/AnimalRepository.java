import java.sql.*;
import java.util.ArrayList;
/**
 * Created by rickiecashwell on 4/3/17.
 */
public class AnimalRepository {
    ArrayList<Animal> animals = new ArrayList<>();
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    private Connection conn;
    public AnimalRepository(String conn) throws SQLException{
        this.conn = DriverManager.getConnection(conn);
    }
    public void saveAnimal(Animal animal) throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.execute("INSERT INTO animals (animal_name, animal_breed, animal_species,animal_description) " +
                "VALUES ('animal.getName() + animal.getBreed() + animal.getSpecies() + animal.getDescription()'");
    }
    public int readAnimalByID(Animal animal) throws SQLException{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT animal_id FROM animals");
            int id=0;
            String name;
            while(rs.next()){
               id = rs.getInt(1);
            }
        return id;
    }
    public void editanimalinDataBase(Animal animal) throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM animals");

    }
    public ArrayList listAnimals(Animal animal) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM animals");
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String breed = rs.getString(3);
            String species = rs.getString(4);
            String description = rs.getString(5);
            animal = new Animal(name,breed,species,description);
        }
        this.animals.add(animal);
        return animals;
    }
    @Override
    public String toString() {
        return "AnimalRepository{" +
                "animals=" + animals +
                '}';
    }
}


