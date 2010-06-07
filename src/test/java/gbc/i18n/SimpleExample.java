package gbc.i18n;

import gbc.i18n.cz.CzechTranscoder;
import gbc.i18n.de.GermanTranscoder;
import gbc.i18n.es.SpanishTranscoder;
import gbc.i18n.fr.FrenchTranscoder;
import gbc.i18n.is.IcelandicTranscoder;
import gbc.i18n.pl.PolishTranscoder;
import gbc.i18n.ro.RomanianTranscoder;
import gbc.i18n.ru.RussianTranscoder;
import gbc.i18n.si.SlovenianTranscoder;
import gbc.i18n.sk.SlovakTranscoder;
import gbc.i18n.ua.UkrainianTranscoder;

public class SimpleExample {

	/**
	 * Showcase
	 * @param args
	 */
	public static void main(String[] args) {

		// START SNIPPET: usage

		// German
		GermanTranscoder german = new GermanTranscoder();
		System.out.println(german.decode("Victor jagt zwölf Boxkämpfer")); // result: Victor jagt zwoelf Boxkaempfer
		System.out.println(german.fromNativeToEntities("Victor jagt zwölf Boxkämpfer")); // result: Victor jagt zw&#246;lf Boxk&#228;mpfer
		System.out.println(german.fromEntitiesToNative("Victor jagt zw&#246;lf Boxk&#228;mpfer")); // result: Victor jagt zwölf Boxkämpfer

		// Spanish
		SpanishTranscoder spanish = new SpanishTranscoder();
		System.out.println(spanish.decode("El veloz murciélago hindú")); // result: El veloz murcielago hindu
		System.out.println(spanish.fromNativeToEntities("El veloz murciélago hindú")); // result: El veloz murci&#233;lago hind&#250
		System.out.println(spanish.fromEntitiesToNative("El veloz murci&#233;lago hind&#250;")); // result: El veloz murciélago hindú

		// French
		FrenchTranscoder french = new FrenchTranscoder();
		System.out.println(french.decode("Voix ambiguë d'un cœur")); // result: Voix ambigue d'un coeur
		System.out.println(french.fromNativeToEntities("Voix ambiguë d'un cœur")); // result: Voix ambigu&#235; d'un c&#339;ur
		System.out.println(french.fromEntitiesToNative("Voix ambigu&#235; d'un c&#339;ur")); // result: Voix ambiguë d'un cœur

		// Polish
		PolishTranscoder polish = new PolishTranscoder();
		System.out.println(polish.decode("Pchnąć w tę łódź jeża lub ośm skrzyń fig")); // result: Pchnac w te lodz jeza lub osm skrzyn fig
		System.out.println(polish.fromNativeToEntities("Pchnąć w tę łódź jeża lub ośm skrzyń fig")); // result: Pchn&#261;&#263; w t&#281; &#322;&#243;d&#378; je&#380;a lub o&#347;m skrzy&#324; fig
		System.out.println(polish.fromEntitiesToNative("Pchn&#261;&#263; w t&#281; &#322;&#243;d&#378; je&#380;a lub o&#347;m skrzy&#324; fig")); // result: Pchnąć w tę łódź jeża lub ośm skrzyń fig

		//Russian
		RussianTranscoder russian = new RussianTranscoder();
		System.out.println(russian.decode("Любя, съешь щипцы, — вздохнёт мэр, — кайф жгуч.")); // result: Luba, sesh shchiptsy, — vzdohnёt mer, — kaif zhguch.
		System.out.println(russian.fromNativeToEntities("Любя, съешь щипцы, — вздохнёт мэр, — кайф жгуч.")); // result: &#1051;&#1102&#1073;&#1103;, &#1089;&#1098;&#1077;&#1096;&#1100; &#1097;&#1080;&#1087;&#1094;&#1099;, — &#1074;&#1079;&#1076;&#1086;&#1093;&#1085;ё&#1090; &#1084;&#1101;&#1088;, — &#1082;&#1072;&#1081;&#1092; &#1078;&#1075;&#1091;&#1095;.
		System.out.println(russian.fromEntitiesToNative("&#1051;&#1102&#1073;&#1103;, &#1089;&#1098;&#1077;&#1096;&#1100; &#1097;&#1080;&#1087;&#1094;&#1099;, — &#1074;&#1079;&#1076;&#1086;&#1093;&#1085;&#1105;&#1090; &#1084;&#1101;&#1088;, — &#1082;&#1072;&#1081;&#1092; &#1078;&#1075;&#1091;&#1095;.")); // result: Любя, съешь щипцы, — вздохнёт мэр, — кайф жгуч.

		//Ukrainian
		UkrainianTranscoder ukrainian = new UkrainianTranscoder();
		System.out.println(ukrainian.decode("Чуєш їх, доцю, га? Кумедна ж ти, прощайся без ґольфів!")); // result: CHuesh ih, dotsu, ga? Kumedna zh ti, proshchaisa bez golfiv!
		System.out.println(ukrainian.fromNativeToEntities("Чуєш їх, доцю, га? Кумедна ж ти, прощайся без ґольфів!")); // result: &#1051;&#1102&#1073;&#1103;, &#1089;&#1098;&#1077;&#1096;&#1100; &#1097;&#1080;&#1087;&#1094;&#1099;, — &#1074;&#1079;&#1076;&#1086;&#1093;&#1085;ё&#1090; &#1084;&#1101;&#1088;, — &#1082;&#1072;&#1081;&#1092; &#1078;&#1075;&#1091;&#1095;.
		System.out.println(ukrainian.fromEntitiesToNative("&#1063;&#1091;&#1108;&#1096; &#1111;&#1093;, &#1076;&#1086;&#1094;&#1102, &#1075;&#1072;? &#1050;&#1091;&#1084;&#1077;&#1076;&#1085;&#1072; &#1078; &#1090;&#1080;, &#1087;&#1088;&#1086;&#1097;&#1072;&#1081;&#1089;&#1103; &#1073;&#1077;&#1079; &#1169;&#1086;&#1083;&#1100;&#1092;&#1110;&#1074;!")); // result: Чуєш їх, доцю, га? Кумедна ж ти, прощайся без ґольфів!

		//Romanian
    RomanianTranscoder romanian = new RomanianTranscoder();
    System.out.println(romanian.decode("Muzicologă în bej vând whisky și tequila, preț fix.")); // result: Muzicologa in bej vand whisky si tequila, pret fix.
    System.out.println(romanian.fromNativeToEntities("Muzicologă în bej vând whisky și tequila, preț fix.")); // result: Muzicolog&#259; &#238;n bej v&#226;nd whisky &#537;i tequila, pre&#539; fix.
    System.out.println(romanian.fromEntitiesToNative("Muzicolog&#259; &#238;n bej v&#226;nd whisky &#537;i tequila, pre&#539; fix.")); // result: Muzicologă în bej vând whisky și tequila, preț fix.

    //Czech
    CzechTranscoder czech = new CzechTranscoder();
    System.out.println(czech.decode("Příliš žluťoučký kůň úpěl ďábelské ódy.")); // result: Prilis zlutoucky kun upel dabelske ody.
    System.out.println(czech.fromNativeToEntities("Příliš žluťoučký kůň úpěl ďábelské ódy.")); // result: P&#345;&#237;li&#353; &#382;lu&#357;ou&#269;k&#253; k&#367;&#328; &#250;p&#283;l &#271;&#225;belsk&#233; &#243;dy.
    System.out.println(czech.fromEntitiesToNative("P&#345;&#237;li&#353; &#382;lu&#357;ou&#269;k&#253; k&#367;&#328; &#250;p&#283;l &#271;&#225;belsk&#233; &#243;dy")); // result: Příliš žluťoučký kůň úpěl ďábelské ódy.
    
    SlovakTranscoder slovak = new SlovakTranscoder();
    System.out.println(slovak.decode("Kŕdeľ šťastných ďatľov učí pri ústí Váhu mĺkveho koňa obhrýzať kôru a žrať čerstvé mäso.")); //result: Krdel stastnych datlov uci pri usti Vahu mlkveho kona obhryzat koru a zrat cerstve maso.
    System.out.println(slovak.fromNativeToEntities("Kŕdeľ šťastných ďatľov učí pri ústí Váhu mĺkveho koňa obhrýzať kôru a žrať čerstvé mäso.")); // result: K&#341;de&#318; &#353;&#357;astn&#253;ch &#271;at&#318;ov u&#269;&#237; pri &#250;st&#237; V&#225;hu m&#314;kveho ko&#328;a obhr&#253;za&#357; k&#243;ru a &#382;ra&#357; &#269;erstv&#233; m&#228;so.
    System.out.println(slovak.fromEntitiesToNative("K&#341;de&#318; &#353;&#357;astn&#253;ch &#271;at&#318;ov u&#269;&#237; pri &#250;st&#237; V&#225;hu m&#314;kveho ko&#328;a obhr&#253;za&#357; k&#243;ru a &#382;ra&#357; &#269;erstv&#233; m&#228;so.")); // result: Kŕdeľ šťastných ďatľov učí pri ústí Váhu mĺkveho koňa obhrýzať kôru a žrať čerstvé mäso.

    SlovenianTranscoder slovenian = new SlovenianTranscoder();
    System.out.println(slovenian.decode("Piškur molče grabi fižol z dna cezijeve hoste.")); //result: Piskur molce grabi fizol z dna cezijeve hoste.
    System.out.println(slovenian.fromNativeToEntities("Piškur molče grabi fižol z dna cezijeve hoste.")); // result: Pi&#353;kur mol&#269;e grabi fi&#382;ol z dna cezijeve hoste.
    System.out.println(slovenian.fromEntitiesToNative("Pi&#353;kur mol&#269;e grabi fi&#382;ol z dna cezijeve hoste.")); // result: Piškur molče grabi fižol z dna cezijeve hoste.
    
    IcelandicTranscoder icelandic = new IcelandicTranscoder();
    System.out.println(icelandic.decode("Kæmi ný öxi hér ykist þjófum nú bæði víl og ádrepa.")); //result: Krdel stastnych datlov uci pri usti Vahu mlkveho kona obhryzat koru a zrat cerstve maso.
    System.out.println(icelandic.fromNativeToEntities("Kæmi ný öxi hér ykist þjófum nú bæði víl og ádrepa.")); // result: K&#230;mi n&#253; &#246;xi h&#233;r ykist &#222;j&#243;fum n&#250; b&#230;&eth;i v&#237;l og &#225;drepa.
    System.out.println(icelandic.fromEntitiesToNative("K&#230;mi n&#253; &#246;xi h&#233;r ykist &#222;j&#243;fum n&#250; b&#230;&eth;i v&#237;l og &#225;drepa.")); // result: Kæmi ný öxi hér ykist þjófum nú bæði víl og ádrepa.
    
		// END SNIPPET: usage
	}

}
