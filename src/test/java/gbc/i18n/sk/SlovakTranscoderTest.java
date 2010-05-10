package gbc.i18n.sk;

import static org.junit.Assert.assertEquals;
import gbc.i18n.AbstractTranscoderTest;

import org.junit.Before;
import org.junit.Test;

public class SlovakTranscoderTest extends AbstractTranscoderTest {

  public static final String TEST_DATA = "Kŕdeľ šťastných ďatľov učí pri ústí Váhu mĺkveho koňa obhrýzať kôru a žrať čerstvé mäso.";
  public static final String TEST_DATA_ENTITIES = "K&#341;de&#318; &#353;&#357;astn&#253;ch &#271;at&#318;ov u&#269;&#237; pri &#250;st&#237; V&#225;hu m&#314;kveho ko&#328;a obhr&#253;za&#357; k&#243;ru a &#382;ra&#357; &#269;erstv&#233; m&#228;so.";
  public static final String EXPECTED_RESULT = "Krdel stastnych datlov uci pri usti Vahu mlkveho kona obhryzat koru a zrat cerstve maso.";

  public static final String[] PANGRAMS = {
    "Kŕdeľ šťastných ďatľov učí pri ústí Váhu mĺkveho koňa obhrýzať kôru a žrať čerstvé mäso.",
    "Kŕdeľ ďatľov učí koňa žrať kôru."
  };

  @Before
  public void setUp() throws Exception {
    transcoder = new SlovakTranscoder();
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
