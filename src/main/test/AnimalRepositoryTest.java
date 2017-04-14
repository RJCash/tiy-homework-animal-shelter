import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.h2.engine.Constants.UTF8;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
/**
 * Created by rickiecashwell on 4/3/17.
 */
public class AnimalRepositoryTest {
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
