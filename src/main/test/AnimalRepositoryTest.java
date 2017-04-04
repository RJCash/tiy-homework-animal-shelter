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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/**
 * Created by rickiecashwell on 4/3/17.
 */
public class AnimalRepositoryTest {
    private String url = "jdbc:h2:mem:animal";
    private Connection conn;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Before
    @Test
    public void readData() throws SQLException {
        try {
            this.conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            AnimalRepository animalRepository = new AnimalRepository(url);
            animalRepository.WriteData();
            ResultSet rs = stmt.executeQuery("SELECT * FROM animals");
            while (rs.next()) {
                String name = rs.getString(1);
                String breed = rs.getString(2);
                String species = rs.getString(3);
                assertThat("Stuffy", equalTo(name));
                assertThat("Grizzly", equalTo(species));
                assertThat("Bear", equalTo(breed));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ResultSet listAnimals() throws SQLException {
        Statement statement = conn.createStatement();
        return statement.executeQuery("SELECT * FROM person");
    }


    @After
    public void x() {

    }
}