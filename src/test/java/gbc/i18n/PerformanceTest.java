package gbc.i18n;

import static org.junit.Assert.*;
import gbc.i18n.Decoder;
import gbc.i18n.pl.PolishDecoder;
import gbc.i18n.pl.PolishDecoderTest;
import gbc.i18n.ru.RussianTranscoder;
import gbc.i18n.ru.RussianTranscoderTest;

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
	public void testDecodePerformance() {
		
		System.out.println("Testing PolishDecoder speed...");
		stressTest(new PolishDecoder(), PolishDecoderTest.TEST_DATA);
		RussianTranscoder transcoder = new RussianTranscoder();
		System.out.println("Testing RussianDecoder speed...");
		stressTest((Decoder)transcoder, RussianTranscoderTest.TEST_DATA);
		System.out.println("Testing RussianTranscoder speed...");
		stressTest(transcoder, RussianTranscoderTest.TEST_DATA);
	}

	private void stressTest(Decoder decoder, final String testData) {
		long start = System.currentTimeMillis();
		for (int i=0; i<EXECUTION_COUNT; i++) {
			@SuppressWarnings("unused")
			String expected = decoder.decode(testData);
		}
		long end = System.currentTimeMillis();
		assertTime(start, end);
	}
	
	private void stressTest(Transcoder transcoder, final String testData) {
		long start = System.currentTimeMillis();
		for (int i=0; i<EXECUTION_COUNT; i++) {
			@SuppressWarnings("unused")
			String expected = transcoder.fromNativeToEntities(testData);
		}
		long end = System.currentTimeMillis();
		assertTime(start, end);
		start = System.currentTimeMillis();
		for (int i=0; i<EXECUTION_COUNT; i++) {
			@SuppressWarnings("unused")
			String expected = transcoder.fromEntitiesToNative(testData);
		}
		end = System.currentTimeMillis();
		assertTime(start, end);
	}

	private void assertTime(long start, long end) {
		long timeDiff = (end-start);
		double executionTime = (timeDiff/(EXECUTION_COUNT));
		System.out.println("Test duration: " + timeDiff + " ms , single execution time: " + executionTime + " ms");
		assertTrue("Decoding is too slow !!!!!! \n It should be less than " + MAXIMUM_EXECUTION_TIME_IN_MILLIS + " ms.", 
				   timeDiff < MAXIMUM_EXECUTION_TIME_IN_MILLIS);
	}

}