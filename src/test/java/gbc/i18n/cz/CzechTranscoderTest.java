package gbc.i18n.cz;

import static org.junit.Assert.assertEquals;
import gbc.i18n.AbstractTranscoderTest;

import org.junit.Before;
import org.junit.Test;

public class CzechTranscoderTest extends AbstractTranscoderTest {

  public static final String TEST_DATA = "Příliš žluťoučký kůň úpěl ďábelské ódy";
  public static final String TEST_DATA_ENTITIES = "P&#345;&#237;li&#353; &#382;lu&#357;ou&#269;k&#253; k&#367;&#328; &#250;p&#283;l &#271;&#225;belsk&#233; &#243;dy";
  public static final String EXPECTED_RESULT = "Prilis zlutoucky kun upel dabelske ody";

  public static final String[] PANGRAMS = {
    "Nechť již hříšné saxofony ďáblů rozzvučí síň úděsnými tóny waltzu, tanga a quickstepu.",
    "Příliš žluťoučký kůň úpěl ďábelské ódy."
  };

  @Before
  public void setUp() throws Exception {
    transcoder = new CzechTranscoder();
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
