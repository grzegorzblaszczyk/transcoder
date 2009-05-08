package gbc.i18n.de;

import static org.junit.Assert.assertEquals;
import gbc.i18n.AbstractTranscoderTest;
import gbc.i18n.Transcoder;

import org.junit.Before;
import org.junit.Test;

public class GermanTranscoderTest extends AbstractTranscoderTest {

	public static final String TEST_DATA = "Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich";
	public static final String TEST_DATA_ENTITIES = "Victor jagt zw&#246;lf Boxk&#228;mpfer quer &#252;ber den gro&#223;en Sylter Deich";
	public static final String EXPECTED_RESULT = "Victor jagt zwoelf Boxkaempfer quer ueber den grossen Sylter Deich";

	public static final String[] PANGRAMS = {
		"Victor jagt zwölf Boxkämpfer quer über den großen Sylter Deich.",
		"\"Fix, Schwyz!\" quäkt Jürgen blöd vom Paß.",
		"Falsches Üben von Xylophonmusik quält jeden größeren Zwerg"
	};
	
	@Before
	public void setUp() throws Exception {
		transcoder = new GermanTranscoder();
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
