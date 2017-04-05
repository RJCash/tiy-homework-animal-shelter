import com.sun.tracing.dtrace.ArgsAttributes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import java.util.Scanner;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * Created by rickiecashwell on 4/3/17.
 */
public class AnimalRepositoryTest {
    private String url = "jdbc:h2:mem:animals;init=runscript FROM 'classpath:./database.sql'";
    private Connection conn;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    @Before
    public void before(){
        try{
            String url = "jdbc:h2:mem:animals";
            statement = conn.createStatement();
            this.conn = DriverManager.getConnection(url);
            AnimalRepository animalRepository = new AnimalRepository(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void readData() throws SQLException {
        try {
            this.conn = DriverManager.getConnection(url);
            statement = conn.createStatement();
            AnimalRepository animalRepository = new AnimalRepository(url);
            Animal animal1 = new Animal("Mitch","Human", "CaveMan", "Some Dude I know");
            animalRepository.saveAnimal(animal1);
            ResultSet rs = statement.executeQuery("SELECT * FROM animals");
            while (rs.next()) {
                String name = rs.getString(1);
                String breed = rs.getString(2);
                String species = rs.getString(3);
                String description = rs.getString(4);
                assertThat("Mitch", equalTo(name));
                assertThat("Human", equalTo(species));
                assertThat("CaveMan", equalTo(breed));
                assertThat("Some dude I Know", equalTo(description));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Test
   public void listAnimalTest() throws SQLException{
        Animal animal1 = new Animal("Mitch","Human", "CaveMan", "Some Dude I know");
        animalRepository.saveAnimal(animal1);
        animalRepository.listAnimals(animal1);
        assertThat(animalRepository.toString(), containsString("Mitch"));
    }
    @After
    public void x() throws SQLException {
    Statement statement = conn.createStatement();
    statement.execute("Shutdown");
    }
}