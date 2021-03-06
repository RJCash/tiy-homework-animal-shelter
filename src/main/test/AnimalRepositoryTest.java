<<<<<<< HEAD
import com.sun.tracing.dtrace.ArgsAttributes;
=======
>>>>>>> v1.2
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
<<<<<<< HEAD
import org.h2.tools.RunScript;
import org.junit.After;
=======
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
>>>>>>> v1.2
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import java.util.Scanner;

import static junit.framework.TestCase.fail;
=======
import java.util.ArrayList;

>>>>>>> v1.2
import static org.h2.engine.Constants.UTF8;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
/**
 * Created by rickiecashwell on 4/3/17.
 */
public class AnimalRepositoryTest {
<<<<<<< HEAD

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
=======
    private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
    private static final String JDBC_URL = "jdbc:h2:mem:animals;DB_CLOSE_DELAY=-1";
    private static final String USER = "";
    private static final String PASSWORD = "";
    @BeforeClass
    public static void createSchema() throws Exception {
        RunScript.execute(JDBC_URL, USER, PASSWORD, "/Users/rickiecashwell/projects/tiy-homework-animal-shelter/src/main/test/resources/database.sql", UTF8, false);
    }
    @Before
    public void importDataSet() throws Exception {
        IDataSet dataSet = readDataSet();
        cleanlyInsert(dataSet);
    }
    private IDataSet readDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new File("set1.xml"));
    }
    public void cleanlyInsert(IDataSet dataSet) throws Exception {
        IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }
    @Test
    public void findsAnimalID() throws Exception {
        AnimalRepository repository = new AnimalRepository(JDBC_URL);
        String name = repository.readAnimalNameByID(1);
        assertThat(name, equalTo("Bob"));
    }
    @Test
    public void JdbcDataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(JDBC_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
    }
    @Test
    public void ListDatabaseAnimal() throws Exception {
        //Connection conn = DriverManager.getConnection(JDBC_URL);
        AnimalRepository repo = new AnimalRepository(JDBC_URL);
        ArrayList<Animal> animals = repo.listAnimalsIndatabase();
       assertThat(animals.get(0).getName(), containsString("Bob"));
    }
}
>>>>>>> v1.2
