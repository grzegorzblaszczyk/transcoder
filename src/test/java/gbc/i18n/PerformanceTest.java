package gbc.i18n;

import static org.junit.Assert.assertTrue;
import gbc.i18n.cz.CzechTranscoder;
import gbc.i18n.de.GermanTranscoder;
import gbc.i18n.es.SpanishTranscoder;
import gbc.i18n.fr.FrenchTranscoder;
import gbc.i18n.pl.PolishTranscoder;
import gbc.i18n.ro.RomanianTranscoder;
import gbc.i18n.ru.RussianTranscoder;
import gbc.i18n.sk.SlovakTranscoder;
import gbc.i18n.ua.UkrainianTranscoder;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PerformanceTest {

  public static Logger logger = Logger.getLogger(PerformanceTest.class);

	private static final int EXECUTION_COUNT = 10000;
	private static final int MAXIMUM_EXECUTION_TIME_IN_MILLIS = 1000;
  private List<Transcoder> transcoders;

	@Before
	public void setUp() throws Exception {
	  transcoders = new ArrayList<Transcoder>();
	  transcoders.add(new GermanTranscoder());
	  transcoders.add(new SpanishTranscoder());
	  transcoders.add(new FrenchTranscoder());
	  transcoders.add(new PolishTranscoder());
	  transcoders.add(new RussianTranscoder());
	  transcoders.add(new UkrainianTranscoder());
	  transcoders.add(new RomanianTranscoder());
	  transcoders.add(new CzechTranscoder());
	  transcoders.add(new SlovakTranscoder());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPerformance() throws ClassNotFoundException, IllegalArgumentException, SecurityException, IllegalAccessException {

    for (Transcoder transcoder : transcoders) {
      Class<?> transcoderTestClass = Class.forName(transcoder.getClass().getName() + "Test");
      String testData = (String)transcoderTestClass.getDeclaredFields()[0].get(new String());
      logger.info("Testing " + transcoder.getClass().getName() + " decoding speed...");
      stressTest((Decoder)transcoder, testData);
      logger.info("Testing " + transcoder.getClass().getName() + " transcoding speed...");
      stressTest(transcoder, testData);
    }
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
