import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.*;

public class TaschenrechnerTest {
	Taschenrechner taschenrechner = new Taschenrechner();
	
	@Before
	public void loeschen() {
		taschenrechner.loeschen();
	}
	
	@Test
	public void addieren(){
		taschenrechner.addieren(5);
		taschenrechner.addieren(10);
		int ergebnis = taschenrechner.getErgebnis();
		assertEquals(ergebnis, 15);
	}

}
