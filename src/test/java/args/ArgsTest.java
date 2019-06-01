package args;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ArgsTest {
    @Test
    public void test1() {
        Args args = new Args("l:bool,d:int,f:string", "-l -d 8080 -f /usr/local");
        assertEquals(args.getValue("l"), Boolean.FALSE);
        assertEquals(args.getValue("d"), new Integer(8080));
        assertEquals(args.getValue("f"), "/usr/local");
    }

    @Test
    public void test_2() {
        Args args = new Args("l:bool,d:int,f:string,s:string", "-l true -d -9 -f /usr/local -s");
        assertEquals(args.getValue("l"), Boolean.TRUE);
        assertEquals(args.getValue("d"), new Integer(-9));
        assertEquals(args.getValue("f"), "/usr/local");
        assertEquals(args.getValue("s"), null);
    }
}
