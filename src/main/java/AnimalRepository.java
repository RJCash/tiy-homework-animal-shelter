import java.sql.*;
/**
 * Created by rickiecashwell on 4/3/17.
 */
public class AnimalRepository {
    private Connection conn;

    public AnimalRepository(String conn) throws SQLException{
        this.conn = DriverManager.getConnection(conn);
    }
    public void WriteData() throws SQLException {
        Animal animal1 = new Animal();
        animal1.addAnimal("Stuffy");
        animal1.setSpecies("Grizzly");
        animal1.setBreed("Bear");
        Statement stmt = conn.createStatement();
        stmt.execute("INSERT INTO animals (animal_name, animal_breed, animal_species) " +
                "VALUES ('" + animal1.getAnimals().get(0) + animal1.getSpecies() + "') ");
    }
}


