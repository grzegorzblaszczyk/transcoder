package gbc.i18n.es;

import static org.junit.Assert.assertEquals;
import gbc.i18n.AbstractTranscoderTest;

import org.junit.Before;
import org.junit.Test;

public class SpanishTranscoderTest extends AbstractTranscoderTest {

	public static final String TEST_DATA = "El veloz murciélago hindú comía feliz cardillo y kiwi. La cigüeña tocaba el saxofón detrás del palenque de paja.";
	public static final String TEST_DATA_ENTITIES = "El veloz murci&#233;lago hind&#250; com&#237;a feliz cardillo y kiwi. La cig&#252;e&#241;a tocaba el saxof&#243;n detr&#225;s del palenque de paja.";
	public static final String EXPECTED_RESULT = "El veloz murcielago hindu comia feliz cardillo y kiwi. La ciguena tocaba el saxofon detras del palenque de paja.";

	public static final String[] PANGRAMS = {
		"El veloz murciélago hindú comía feliz cardillo y kiwi. La cigüeña tocaba el saxofón detrás del palenque de paja.",
		"El pingüino Wenceslao hizo kilómetros bajo exhaustiva lluvia y frío; añoraba a su querido cachorro.",
		"Jovencillo emponzoñado de whisky: ¡qué figurota exhibe!",
		"Ese libro explica en su epígrafe las hazañas y aventuras de Don Quijote de la Mancha en Kuwait.",
		"Queda gazpacho, fibra, látex, jamón, kiwi y viñas. ",
		"Whisky bueno: ¡excitad mi frágil pequeña vejez!"
	};

	@Before
	public void setUp() throws Exception {
		transcoder = new SpanishTranscoder();
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
