import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
/**
 * Created by rickiecashwell on 3/28/17.
 */
public class MainTest {
    private ByteArrayOutputStream outputStream;
            @Rule
            public final TextFromStandardInputStream systemInMock
                    = emptyStandardInputStream();
            public final ExpectedSystemExit exit = ExpectedSystemExit.none();
            public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
            @Test
            public void testMockInput() {
                Main main = new Main();
                systemInMock.provideText("5");
                Scanner scan = new Scanner(System.in);
                assertThat("5", equalTo(scan.nextLine()));
            }
            @Test
            public void containStringMockTest(){
                Main main = new Main();
                systemInMock.provideText("1\n");
                Scanner scan = new Scanner(System.in);
                assertThat("1", containsString(scan.nextLine()));
            }
            public void ListAnimalMockTest(){
                Main main = new Main();
                systemInMock.provideText("2");
            }
            @Test
            public void exits () {
                Main main = new Main();
            systemInMock.provideText("6");
            Scanner scan = new Scanner(System.in);
            exit.expectSystemExit();
        }
        @Test
        public void exitsWithStatusCode1 () {
            Main main = new Main();
            systemInMock.provideText("6");
            Scanner scan = new Scanner(System.in);
            exit.expectSystemExitWithStatus(1);
        }
    }
