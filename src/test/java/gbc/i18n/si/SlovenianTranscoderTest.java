package gbc.i18n.si;

import static org.junit.Assert.assertEquals;
import gbc.i18n.AbstractTranscoderTest;
import gbc.i18n.Transcoder;

import org.junit.Before;
import org.junit.Test;

public class SlovenianTranscoderTest extends AbstractTranscoderTest {

  public static final String TEST_DATA = "Piškur molče grabi fižol z dna cezijeve hoste.";
  public static final String TEST_DATA_ENTITIES = "Pi&#353;kur mol&#269;e grabi fi&#382;ol z dna cezijeve hoste.";
  public static final String EXPECTED_RESULT = "Piskur molce grabi fizol z dna cezijeve hoste.";

  public static final String[] PANGRAMS = {
    "Hišničin bratec vzgaja polže pod fikusom.",
    "Besni dirkač iz formule žuga cehu poštarjev.",
    "Fučka se mi hladna goveja žolca brez pršuta.",
    "Šerif bo za vajo spet kuhal domače žgance. ",
    "Piškur molče grabi fižol z dna cezijeve hoste.",
    "V kožuščku hudobnega fanta stopiclja mizar."
  };

  Transcoder transcoder = null;

  @Before
  public void setUp() throws Exception {
    transcoder = new SlovenianTranscoder();
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
