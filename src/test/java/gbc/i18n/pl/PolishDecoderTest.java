package gbc.i18n.pl;

import static org.junit.Assert.*;
import gbc.i18n.Decoder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PolishDecoderTest {

	public static final String TEST_DATA = "zażółć gęślą jaźń";
	public static final String EXPECTED_RESULT = "zazolc gesla jazn";
	
	public static final String[][] PANGRAMS = {
		{"Pchnąć w tę łódź jeża lub ośm skrzyń fig.", "Pchnac w te lodz jeza lub osm skrzyn fig."},
		{"Pójdźże, kiń tę chmurność w głąb flaszy!", "Pojdzze, kin te chmurnosc w glab flaszy!"},
		{"Dość gróźb fuzją, klnę, pych i małżeństw!", "Dosc grozb fuzja, klne, pych i malzenstw!"},
		{"Pójdź w loch zbić małżeńską gęś futryn!", "Pojdz w loch zbic malzenska ges futryn!"},
		{"Filmuj rzeź żądań, pość, gnęb chłystków!", "Filmuj rzez zadan, posc, gneb chlystkow!"},
		{"O, mógłże sęp chlań wyjść furtką bździn.", "O, moglze sep chlan wyjsc furtka bzdzin."},
		{"Mężny bądź, chroń pułk twój i sześć flag.", "Mezny badz, chron pulk twoj i szesc flag."},
		{"Chwyć małżonkę, strój bądź pleśń z fugi.", "Chwyc malzonke, stroj badz plesn z fugi."}
	};
	
	private Decoder decoder;
	
	@Before
	public void setUp() throws Exception {
		decoder = new PolishDecoder();
	}

	@After
	public void tearDown() throws Exception {
		decoder = null;
	}

	@Test
	public void testDecode() {
		assertEquals(EXPECTED_RESULT, decoder.decode(TEST_DATA));
		assertEquals(EXPECTED_RESULT.toUpperCase(), decoder.decode(TEST_DATA.toUpperCase()));
	}
	
	@Test
	public void testPangrams() {
		for (int i=0; i<PANGRAMS.length; i++) {
			assertEquals(PANGRAMS[i][1], decoder.decode(PANGRAMS[i][0]));
		}
	}
}
