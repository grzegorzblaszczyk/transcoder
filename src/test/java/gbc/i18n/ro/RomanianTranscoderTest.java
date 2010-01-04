package gbc.i18n.ro;

import static org.junit.Assert.assertEquals;
import gbc.i18n.AbstractTranscoderTest;
import gbc.i18n.Transcoder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RomanianTranscoderTest extends AbstractTranscoderTest {

	public static final String TEST_DATA = "Muzicologă în bej vând whisky și tequila, preț fix.";
	public static final String TEST_DATA_ENTITIES = "Muzicolog&#259; &#238;n bej v&#226;nd whisky &#537;i tequila, pre&#539; fix.";
	public static final String EXPECTED_RESULT = "Muzicologa in bej vand whisky si tequila, pret fix.";

	public static final String[] PANGRAMS = {
    "Muzicologă în bej vând whisky și tequila, preț fix.",
    "Bând whisky, jazologul șprițuit vomă fix în tequila.",
    "Ex-sportivul își fumează jucăuş ţigara bând whisky cu tequila.",
    "Înjurând pițigăiat, zoofobul comandă vexat whisky și tequila."
	};

	Transcoder transcoder = null;

	@Before
	public void setUp() throws Exception {
		transcoder = new RomanianTranscoder();
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
	public void testEntitiesAndNative() {
		testEntitiesAndNative(transcoder, TEST_DATA, TEST_DATA_ENTITIES);
		testPangrams(transcoder, PANGRAMS);
	}
}
