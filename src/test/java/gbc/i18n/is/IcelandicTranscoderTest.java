package gbc.i18n.is;

import static org.junit.Assert.assertEquals;
import gbc.i18n.AbstractTranscoderTest;

import org.junit.Before;
import org.junit.Test;

public class IcelandicTranscoderTest extends AbstractTranscoderTest {

	public static final String TEST_DATA = "Kæmi ný öxi hér ykist þjófum nú bæði víl og ádrepa.";
	public static final String TEST_DATA_ENTITIES = "K&#230;mi n&#253; &#246;xi h&#233;r ykist &#222;j&#243;fum n&#250; b&#230;&eth;i v&#237;l og &#225;drepa.";
	public static final String EXPECTED_RESULT = "Kaemi ny oexi her ykist thjofum nu baeethi vil og adrepa.";

	public static final String[] PANGRAMS = {
		"Kæmi ný öxi hér ykist þjófum nú bæði víl og ádrepa.",
		"Svo hölt, yxna kýr þegði jú um dóp í fé á bæ."
	};

	@Before
	public void setUp() throws Exception {
		transcoder = new IcelandicTranscoder();
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
