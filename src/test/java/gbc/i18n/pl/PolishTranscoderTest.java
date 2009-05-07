package gbc.i18n.pl;

import static org.junit.Assert.assertEquals;
import gbc.i18n.AbstractTranscoderTest;

import org.junit.Before;
import org.junit.Test;

public class PolishTranscoderTest extends AbstractTranscoderTest {

	public static final String TEST_DATA = "zażółć gęślą jaźń";
	public static final String TEST_DATA_ENTITIES = "za&#380;&#243;&#322;&#263; g&#281;&#347;l&#261; ja&#378;&#324;";
	public static final String EXPECTED_RESULT = "zazolc gesla jazn";
	
	public static final String[] PANGRAMS = {
		"Pchnąć w tę łódź jeża lub ośm skrzyń fig.",
		"Pójdźże, kiń tę chmurność w głąb flaszy!",
		"Dość gróźb fuzją, klnę, pych i małżeństw!",
		"Pójdź w loch zbić małżeńską gęś futryn!",
		"Filmuj rzeź żądań, pość, gnęb chłystków!",
		"O, mógłże sęp chlań wyjść furtką bździn.",
		"Mężny bądź, chroń pułk twój i sześć flag.",
		"Chwyć małżonkę, strój bądź pleśń z fugi."
	};
	
	@Before
	public void setUp() throws Exception {
		transcoder = new PolishTranscoder();
	}

	@Test
	public void testDecode() {
		assertEquals(EXPECTED_RESULT, transcoder.decode(TEST_DATA));
		assertEquals(EXPECTED_RESULT.toUpperCase(), transcoder.decode(TEST_DATA.toUpperCase()));
	}
	
	@Test
	public void testEntitiesAndNative() {
		testEntitiesAndNative(transcoder, TEST_DATA, TEST_DATA_ENTITIES);
	}
	
	@Test
	public void testPangrams() {
		super.testPangrams(transcoder, PANGRAMS);
	}
}
