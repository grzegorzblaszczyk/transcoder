package gbc.i18n;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;

public abstract class AbstractTranscoderTest {

	protected Transcoder transcoder = null;

	public void testPangrams(Transcoder transcoder, final String[] pangrams) {
		for (final String pangram : pangrams) {
			assertEquals(pangram, transcoder.fromEntitiesToNative(transcoder.fromNativeToEntities(pangram)));
		}
	}

	@After
	public void tearDown() throws Exception {
		transcoder = null;
	}
	
	protected void testEntitiesAndNative(Transcoder transcoder,
			final String testData, final String testDataEntities) {
		String entitiesToNative = transcoder.fromEntitiesToNative(testDataEntities);
		assertTrue(!entitiesToNative.contains("&#"));
		assertEquals(testData, entitiesToNative);
		assertEquals(testDataEntities, transcoder.fromNativeToEntities(testData));
	}
}
