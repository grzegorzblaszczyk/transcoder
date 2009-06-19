package gbc.i18n.fr;

import static org.junit.Assert.assertEquals;
import gbc.i18n.AbstractTranscoderTest;

import org.junit.Before;
import org.junit.Test;

public class FrenchTranscoderTest extends AbstractTranscoderTest {

	public static final String TEST_DATA = "Voix ambiguë d'un cœur qui au zéphyr préfère les jattes de kiwi";
	public static final String TEST_DATA_ENTITIES = "Voix ambigu&#235; d'un c&#339;ur qui au z&#232;phyr pr&#232;f&#233;re les jattes de kiwi";
	public static final String EXPECTED_RESULT = "Voix ambigue d'un coeur qui au zephyr prefere les jattes de kiwi";

	public static final String[] PANGRAMS = {
		"Buvez de ce whisky que le patron juge fameux." +
		"Portez ce vieux whisky au juge blond qui fume" +
		"Bâchez la queue du wagon-taxi avec les pyjamas du fakir" +
		"Voyez le brick géant que j'examine près du wharf" +
		"Voix ambiguë d'un cœur qui au zéphyr préfère les jattes de kiwi"
	};

	@Before
	public void setUp() throws Exception {
		transcoder = new FrenchTranscoder();
	}

	@Test
	public void testDecode() {
		assertEquals(EXPECTED_RESULT, transcoder.decode(TEST_DATA));
		assertEquals(EXPECTED_RESULT.toUpperCase(), transcoder.decode(TEST_DATA.toUpperCase()).toUpperCase());
	}

	@Test
	public void testEntitiesAndNative() {
		testEntitiesAndNative(transcoder, TEST_DATA, TEST_DATA_ENTITIES);
		testPangrams(transcoder, PANGRAMS);
	}

}
