package gbc.i18n;

import static org.junit.Assert.assertTrue;
import gbc.i18n.de.GermanTranscoder;
import gbc.i18n.de.GermanTranscoderTest;
import gbc.i18n.es.SpanishTranscoder;
import gbc.i18n.es.SpanishTranscoderTest;
import gbc.i18n.pl.PolishTranscoder;
import gbc.i18n.pl.PolishTranscoderTest;
import gbc.i18n.ru.RussianTranscoder;
import gbc.i18n.ru.RussianTranscoderTest;
import gbc.i18n.ua.UkrainianTranscoder;
import gbc.i18n.ua.UkrainianTranscoderTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PerformanceTest {

	private static final int EXECUTION_COUNT = 10000;
	private static final int MAXIMUM_EXECUTION_TIME_IN_MILLIS = 1000;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPerformance() {

		System.out.println("Testing PolishDecoder speed...");
		Transcoder polishTranscoder = new PolishTranscoder();
		stressTest(polishTranscoder, PolishTranscoderTest.TEST_DATA);
		System.out.println("Testing PolishTranscoder speed...");
		stressTest(polishTranscoder, PolishTranscoderTest.TEST_DATA);

		RussianTranscoder russianTranscoder = new RussianTranscoder();
		System.out.println("Testing RussianDecoder speed...");
		stressTest((Decoder) russianTranscoder, RussianTranscoderTest.TEST_DATA);
		System.out.println("Testing RussianTranscoder speed...");
		stressTest(russianTranscoder, RussianTranscoderTest.TEST_DATA);

		UkrainianTranscoder ukrainianTranscoder = new UkrainianTranscoder();
		System.out.println("Testing UkrainianDecoder speed...");
		stressTest((Decoder) ukrainianTranscoder,
				UkrainianTranscoderTest.TEST_DATA);
		System.out.println("Testing UkrainianTranscoder speed...");
		stressTest(ukrainianTranscoder, UkrainianTranscoderTest.TEST_DATA);

		GermanTranscoder germanTranscoder = new GermanTranscoder();
		System.out.println("Testing GermanDecoder speed...");
		stressTest((Decoder) germanTranscoder, GermanTranscoderTest.TEST_DATA);
		System.out.println("Testing GermanTranscoder speed...");
		stressTest(germanTranscoder, GermanTranscoderTest.TEST_DATA);

    SpanishTranscoder spanishTranscoder = new SpanishTranscoder();
    System.out.println("Testing SpanishDecoder speed...");
    stressTest((Decoder) spanishTranscoder, SpanishTranscoderTest.TEST_DATA);
    System.out.println("Testing SpanishTranscoder speed...");
    stressTest(spanishTranscoder, SpanishTranscoderTest.TEST_DATA);
	}

	private void stressTest(Decoder decoder, final String testData) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < EXECUTION_COUNT; i++) {
			@SuppressWarnings("unused")
			String expected = decoder.decode(testData);
		}
		long end = System.currentTimeMillis();
		assertTime(start, end);
	}

	private void stressTest(Transcoder transcoder, final String testData) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < EXECUTION_COUNT; i++) {
			@SuppressWarnings("unused")
			String expected = transcoder.fromNativeToEntities(testData);
		}
		long end = System.currentTimeMillis();
		assertTime(start, end);
		start = System.currentTimeMillis();
		for (int i = 0; i < EXECUTION_COUNT; i++) {
			@SuppressWarnings("unused")
			String expected = transcoder.fromEntitiesToNative(testData);
		}
		end = System.currentTimeMillis();
		assertTime(start, end);
	}

	private void assertTime(long start, long end) {
		long timeDiff = (end - start);
		double executionTime = (timeDiff / (EXECUTION_COUNT));
		System.out.println("Test duration: " + timeDiff
				+ " ms , single execution time: " + executionTime + " ms");
		assertTrue("Decoding is too slow !!!!!! \n It should be less than "
				+ MAXIMUM_EXECUTION_TIME_IN_MILLIS + " ms.",
				timeDiff < MAXIMUM_EXECUTION_TIME_IN_MILLIS);
	}

}
