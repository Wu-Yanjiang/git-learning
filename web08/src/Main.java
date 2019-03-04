import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import com.mysql.jdbc.driver;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    @Test
    public void testJunit(){
        System.out.println("Hello Junit");
    }

    @Before
    public void testBefore(){
        System.out.println("Before!");
    }

    @After
    public void testAfter(){
        System.out.println("After!");
    }

}
