import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;


/**
 *
 * @author Jingyi Lin (jil173)
 */
public class MainPanelTest {
    @Before
    public void setUp() throws Exception {
        // If you use @Mock, you need to do this
    }

    @After
    public void tearDown() throws Exception {
        
    }	
    
    // --------------------------------------------------------------
    // MainPanel.getNumNeighbors() TESTS (MainPanel.java)
    //      Test getNumNeighbors() method can give the same result 
    //      as before after modification
    // --------------------------------------------------------------
    
    //  Assume there is a cell without knowing its neighbors' condition,
    //  so the number returned by getNumNeighbors() should be the same
    //  as the original method getNumNeighborsRetired()
    @Test
    public void testGetNumNeighborsSame() {
        int size = 15;
        MainPanel mp = new MainPanel(size);
        Cell[][] cell = new Cell[size][size];
        Random r = new Random();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cell[i][j] = new Cell();
                cell[i][j].setAlive(r.nextBoolean());
            }
        }
        mp.setCells(cell);
        int before = mp.getNumNeighborsRetired(1, 2);
        int after = mp.getNumNeighbors(1, 2);
        assertEquals(before, after);
    }
    
    //  Assume there is a cell with all neighbor cells are dead,
    //  so the number returned by getNumNeighborsRetired() should be 0,
    //  test modified getNumNeighbors() can also get 0
    @Test
    public void testGetNumNeighborsDead() {
        int size = 15;
        MainPanel mp = new MainPanel(size);
        Cell[][] cell = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cell[i][j] = new Cell();
                cell[i][j].setAlive(false);
            }
        }
        mp.setCells(cell);
        int before = mp.getNumNeighborsRetired(1, 2);
        int after = mp.getNumNeighbors(1, 2);
        assertEquals(before, 0);
        assertEquals(after, 0);
    }
    
    //  Assume there is a cell with all neighbor cells are alive,
    //  so the number returned by getNumNeighborsRetired() should be 8,
    //  test modified getNumNeighbors() can also get 8
    @Test
    public void testGetNumNeighborsAlive() {
        int size = 15;
        MainPanel mp = new MainPanel(size);
        Cell[][] cell = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cell[i][j] = new Cell();
                cell[i][j].setAlive(true);
            }
        }
        mp.setCells(cell);
        int before = mp.getNumNeighborsRetired(1, 2);
        int after = mp.getNumNeighbors(1, 2);
        assertEquals(before, 8);
        assertEquals(after, 8);
    }
    
    
    // --------------------------------------------------------------
    // MainPanel.backup() TESTS (MainPanel.java)
    //      Test backup() method can give the same result 
    //      as before after modification
    // --------------------------------------------------------------
    
    //  Assume there is a cell without knowing its condition,
    //  the cells backuped by backup() should be the same
    //  as the original method backupRetired()
    @Test
    public void testBackupSame() {
        int size = 15;
        MainPanel mp = new MainPanel(size);
        Cell[][] cell = new Cell[size][size];
        Random r = new Random();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cell[i][j] = new Cell();
                cell[i][j].setAlive(r.nextBoolean());
            }
        }
        mp.setCells(cell);
        mp.backupRetired();
        Cell before = mp._backupCells[1][2];
        mp.backup();
        Cell after = mp._backupCells[1][2];
        assertEquals(before.getAlive(), after.getAlive());
    }
    
    //  Assume there is a cell with dead neighbors,
    //  the cells backuped by backup() should be the same
    //  as the original method backupRetired()
    @Test
    public void testBackupDead() {
        int size = 15;
        MainPanel mp = new MainPanel(size);
        Cell[][] cell = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cell[i][j] = new Cell();
                cell[i][j].setAlive(false);
            }
        }
        mp.setCells(cell);
        mp.backupRetired();
        Cell before = mp._backupCells[1][2];
        mp.backup();
        Cell after = mp._backupCells[1][2];
        assertEquals(before.getAlive(), after.getAlive());
    }
    
    //  Assume there is a cell with alive neighbors,
    //  the cells backuped by backup() should be the same
    //  as the original method backupRetired()
    @Test
    public void testBackupAlive() {
        int size = 15;
        MainPanel mp = new MainPanel(size);
        Cell[][] cell = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cell[i][j] = new Cell();
                cell[i][j].setAlive(true);
            }
        }
        mp.setCells(cell);
        mp.backupRetired();
        Cell before = mp._backupCells[1][2];
        mp.backup();
        Cell after = mp._backupCells[1][2];
        assertEquals(before.getAlive(), after.getAlive());
    }
   
}
    
