package gbc.i18n.ru;

import static org.junit.Assert.assertEquals;
import gbc.i18n.Transcoder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RussianTranscoderTest {

	public static final String TEST_DATA = "Гарри Поттер и Принц-полукровка";
	public static final String TEST_DATA_ENTITIES = "&#1043;&#1072;&#1088;&#1088;&#1080; &#1055;&#1086;&#1090;&#1090;&#1077;&#1088; &#1080; &#1055;&#1088;&#1080;&#1085;&#1094;-&#1087;&#1086;&#1083;&#1091;&#1082;&#1088;&#1086;&#1074;&#1082;&#1072;";
	public static final String EXPECTED_RESULT = "Garri Potter i Prints-polukrovka";

	public static final String[] PANGRAMS = {
		"Любя, съешь щипцы, — вздохнёт мэр, — кайф жгуч.",
		"Шеф взъярён тчк щипцы с эхом гудбай Жюль.",
		"Эй, жлоб! Где туз? Прячь юных съёмщиц в шкаф.",
		"Экс-граф? Плюш изъят. Бьём чуждый цен хвощ!",
		"Эх, чужак! Общий съём цен шляп (юфть) — вдрызг!"
	};
	
	Transcoder transcoder = null;
	
	@Before
	public void setUp() throws Exception {
		transcoder = new RussianTranscoder();
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
