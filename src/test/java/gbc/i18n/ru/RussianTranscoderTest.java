package gbc.i18n.ru;

import static org.junit.Assert.assertEquals;
import gbc.i18n.AbstractTranscoderTest;
import gbc.i18n.Transcoder;

import org.junit.Before;
import org.junit.Test;

public class RussianTranscoderTest extends AbstractTranscoderTest {

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

	@Test
	public void testDecode() {
		assertEquals(EXPECTED_RESULT, transcoder.decode(TEST_DATA));
		assertEquals(EXPECTED_RESULT.toUpperCase(), transcoder.decode(TEST_DATA.toUpperCase()));
	}

	@Test
	public void testEntitiesAndNative() {
		testEntitiesAndNative(transcoder, TEST_DATA, TEST_DATA_ENTITIES);
		testPangrams(transcoder, PANGRAMS);
	}
	
}
