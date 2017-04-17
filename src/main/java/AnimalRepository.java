import java.sql.*;
import java.util.ArrayList;

/**
 * Created by rickiecashwell on 4/3/17.
 */
public class AnimalRepository {
    private Connection conn;

    public AnimalRepository(String conn) throws SQLException {
        this.conn = DriverManager.getConnection(conn);
    }
    public void deleteAnimal(Animal animal) throws SQLException{
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM animals WHERE animal_name = ?");
        stmt.setString(1,animal.getName());
        stmt.execute();
    }
    public void insertAnimal(Animal animal) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement( "INSERT INTO animals (animal_name, animal_breed, animal_species, animal_description) " +
                "VALUES (?,?,?,?)");
                stmt.setString(1, animal.getName());
                stmt.setString(2, animal.getBreed());
                stmt.setString(3, animal.getSpecies());
                stmt.setString(4, animal.getDescription());
                stmt.execute();
    }

    public String readAnimalNameByID(int id) throws SQLException {
        String name = null;
        PreparedStatement prepstmt = conn.prepareStatement("SELECT * FROM animals WHERE animalid = ?");
        prepstmt.setInt(1,id);
        ResultSet rs = prepstmt.executeQuery();
        while(rs.next()){
        name = rs.getString("animal_name");
        }
        return name;
    }
    public int readIDbyAnimalName(String name) throws SQLException {
        Integer id = null;
        PreparedStatement prepstmt = conn.prepareStatement("SELECT * FROM animals WHERE animal_name = ?");
        prepstmt.setInt(1,id);
        ResultSet rs = prepstmt.executeQuery();
        while(rs.next()){
            id = rs.getInt("animalid");
        }
        return id;
    }
    public void editanimalinDataBase(int id, Animal animal) throws SQLException {
    PreparedStatement stmt = conn.prepareStatement(
            "UPDATE animals SET animal_name = ?, animal_breed =?,animal_species=?,animal_description=? WHERE animalid=?");
            stmt.setString(1, animal.getName());
            stmt.setString(2, animal.getBreed());
            stmt.setString(3, animal.getSpecies());
            stmt.setString(4, animal.getDescription());
            stmt.setInt(5, id);
            stmt.execute();

    }
    public ArrayList<Animal> listAnimalsIndatabase() throws SQLException {
        ArrayList<Animal> animals = new ArrayList<>();
        PreparedStatement ps = conn.prepareStatement
                ("SELECT * FROM animals");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Animal animal;
            int id = rs.getInt("animalid");
            String name = rs.getString("animal_name");
            String breed = rs.getString("animal_breed");
            String description = rs.getString("animal_description");
            String species = rs.getString("animal_species");
            animal = new Animal(id, name, species, breed, description);
            animals.add(animal);
        }
        return animals;
    }
}


