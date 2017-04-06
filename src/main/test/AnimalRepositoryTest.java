import com.sun.tracing.dtrace.ArgsAttributes;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.tools.RunScript;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import java.util.Scanner;

import static junit.framework.TestCase.fail;
import static org.h2.engine.Constants.UTF8;
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

        private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
        private static final String JDBC_URL = "jdbc:h2:mem:animals;DB_CLOSE_DELAY=-1";
        private static final String USER = "username";
        private static final String PASSWORD = "password";

        @BeforeClass
        public static void createSchema() throws Exception {
            RunScript.execute(JDBC_URL, USER, PASSWORD, "database.sql", UTF8, false);
        }
        @Before
        public void importDataSet() throws Exception {
            IDataSet dataSet = readDataSet();
            cleanlyInsert(dataSet);
        }

        private IDataSet readDataSet() throws Exception {
            return new FlatXmlDataSetBuilder().build(new File("dataset.xml"));
        }

        private void cleanlyInsert(IDataSet dataSet) throws Exception {
            IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
            databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
            databaseTester.setDataSet(dataSet);
            databaseTester.onSetup();
        }

        @Test
        public void findsAndReadsExistingPersonByFirstName() throws Exception {
            AnimalRepository repository = new AnimalRepository(dataSource());
            Animal dave = repository.findAnimalByName("dave");

            assertThat(dave.getFirstName(), is("dave"));
            assertThat(dave.getspecies(), is("dog"));
            assertThat(dave.getbreed(), is("labrador"));
        }

        @Test
        public void returnsNullWhenPersonCannotBeFoundByFirstName() throws Exception {
            PersonRepository repository = new PersonRepository(dataSource());
            Person person = repository.findPersonByFirstName("iDoNotExist");

            assertThat(person, is(nullValue()));
        }

        private DataSource dataSource() {
            JdbcDataSource dataSource = new JdbcDataSource();
            dataSource.setURL(JDBC_URL);
            dataSource.setUser(USER);
            dataSource.setPassword(PASSWORD);
            return dataSource;
        }
    }
}















/*private String url = "jdbc:h2:mem:animals;init=runscript FROM 'classpath:./database.sql'";
    private Connection conn;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Test
    public void readData() throws SQLException {
        try {
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
        AnimalRepository animalRepository = new AnimalRepository(url);
        Animal animal1 = new Animal("Mitch","Human", "CaveMan", "Some Dude I know");
        assertThat(animalRepository.listAnimals(animal1).toString(), containsString("Mitch"));
    }
    @After
    public void x() throws SQLException {
        conn.close();

    }*/