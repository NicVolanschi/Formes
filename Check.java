import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class Check {

    @Test
    public void thisAlwaysPasses() {
    }

    /*
    @Test
    public void thisAlwaysFails() {
	assertEquals(1,2);
    } 
    */   

    @Test
    @Ignore
    public void thisIsIgnored() {
    }
}
