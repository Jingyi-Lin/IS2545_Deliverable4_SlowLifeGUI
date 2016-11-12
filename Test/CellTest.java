import org.junit.*;
import static org.junit.Assert.*;


/**
 *
 * @author Jingyi Lin (jil173)
 */
public class CellTest {
    @Before
    public void setUp() throws Exception {
        // If you use @Mock, you need to do this
    }

    @After
    public void tearDown() throws Exception {
        
    }	
    
    // --------------------------------------------------------------
    // Cell.toString() TESTS (Cell.java)
    //      Test toString() method can give the same result 
    //      as before after modification
    // --------------------------------------------------------------
    
    //  Assume there is a cell,
    //  use toStringRetired() method and toString() method
    //  to get the text on the cell,
    //  and they should be the same
    @Test
    public void testToStringSame() {
        Cell cell = new Cell();
        String before = cell.toStringRetired();
        String after = cell.toString();
        assertEquals(before, after);
    }
    
    //  Assume the cell is dead,
    //  use toStringRetired() method can get the text on each cell as ".",
    //  test modified toString() give same result as "."
    @Test
    public void testToStringDead(){
        Cell cell = new Cell();
        cell.setAlive(false);
        String after = cell.toString();
        assertEquals(after , ".");
    }
    
    //  Assume the cell is alive,
    //  use toStringRetired() method can get the text on each cell as "X",
    //  test modified toString() give same result as "X"
    @Test
    public void testToStringAlive() {
        Cell cell = new Cell();
        cell.setAlive(true);
        String after = cell.toString();
        assertEquals(after, "X");
    }
    
}
