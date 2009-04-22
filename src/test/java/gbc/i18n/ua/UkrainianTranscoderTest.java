package gbc.i18n.ua;

import static org.junit.Assert.assertEquals;
import gbc.i18n.Transcoder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UkrainianTranscoderTest {

	public static final String TEST_DATA = "Польськa Mовa за 4 Tижні";
	public static final String TEST_DATA_ENTITIES = "&#1055;&#1086;&#1083;&#1100;&#1089;&#1100;&#1082;a M&#1086;&#1074;a &#1079;&#1072; 4 T&#1080;&#1078;&#1085;&#1110;";
	public static final String EXPECTED_RESULT = "Polska Mova za 4 Tizhni";

	public static final String[] PANGRAMS = {
		"Чуєш їх, доцю, га? Кумедна ж ти, прощайся без ґольфів!",
		"Жебракують філософи при ґанку церкви в Гадячі, ще й шатро їхнє п'яне знаємо.",
	};

	Transcoder transcoder = null;

	@Before
	public void setUp() throws Exception {
		transcoder = new UkrainianTranscoder();
	}

	@After
	public void tearDown() throws Exception {
		transcoder = null;
	}

	@Test
	public void testDecode() {
		assertEquals(EXPECTED_RESULT, transcoder.decode(TEST_DATA));
		assertEquals(EXPECTED_RESULT.toUpperCase(), transcoder.decode(TEST_DATA.toUpperCase()));
	}

	@Test
	public void testFromEntitiesToNative() {
		assertEquals(TEST_DATA, transcoder.fromEntitiesToNative(TEST_DATA_ENTITIES));
	}

	@Test
	public void testFromNativeToEntities() {
		assertEquals(TEST_DATA_ENTITIES, transcoder.fromNativeToEntities(TEST_DATA));
	}

	@Test
	public void testPangrams() {
		for (String pangram : PANGRAMS) {
			assertEquals(pangram, transcoder.fromEntitiesToNative(transcoder.fromNativeToEntities(pangram)));
		}
	}
}
