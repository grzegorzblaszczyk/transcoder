package gbc.i18n.pl;

import org.apache.commons.lang.StringUtils;

import gbc.i18n.Decoder;

public class PolishDecoder implements Decoder {

	private static final char[][] UNICODE_DECODE_TABLE={	
		{'\u00d3','O'},
		{'\u00f3','o'},
		{'\u0104','A'},
	  	{'\u0105','a'},
	  	{'\u0106','C'},
	  	{'\u0107','c'},
	  	{'\u0118','E'},
	  	{'\u0119','e'},
	  	{'\u0141','L'},	
	  	{'\u0142','l'},
	  	{'\u0143','N'},
	  	{'\u0144','n'},
	  	{'\u015a','S'},
	  	{'\u015b','s'},
	  	{'\u017b','Z'},
	  	{'\u017c','z'},
	  	{'\u0179','Z'},
	  	{'\u017a','z'},
	  	
	  };
	//\u00e4\u00f6\u00fc\u00c4\u00d6\u00dc\u00eb\u00ef\u00ff\u00cb\u00cf\u0178\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f9\u00fa\u00fb\u00fc\u00fd\u00fe\u00ff\u00C0\u00C1\u00C2\u00C3\u00C4\u00C5\u00C6\u00C7\u00C8\u00C9\u00CA\u00CB\u00CC\u00CD\u00CE\u00CF\u00D0\u00D1\u00D2\u00D3\u00D4\u00D5\u00D6\u00D7\u00D8\u00D9\u00DA\u00DB\u00DC\u00DD\u00DE\u00DF";
	
	//private static String changeTo = "aouAOUeiyEIYaaaaaaaceeeeiiiionooooouuuuypyAAAAAAACEEEEIIIIDNOOOOOXOUUUUYPB";

	
	@Override
	public String decode(final String input) {
		String output = input;
		output = decodeUnicode(output);
		//System.out.println("\u00e4\u00f6\u00fc\u00c4\u00d6\u00dc\u00eb\u00ef\u00ff\u00cb\u00cf\u0178\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f9\u00fa\u00fb\u00fc\u00fd\u00fe\u00ff\u00C0\u00C1\u00C2\u00C3\u00C4\u00C5\u00C6\u00C7\u00C8\u00C9\u00CA\u00CB\u00CC\u00CD\u00CE\u00CF\u00D0\u00D1\u00D2\u00D3\u00D4\u00D5\u00D6\u00D7\u00D8\u00D9\u00DA\u00DB\u00DC\u00DD\u00DE\u00DF");
		return output;
	}


	private String decodeUnicode(final String input) {
		String output = input;
		for (int i=0; i<UNICODE_DECODE_TABLE.length; i++) {
			output = StringUtils.replaceChars(output, UNICODE_DECODE_TABLE[i][0], UNICODE_DECODE_TABLE[i][1]);
		}
		return output;
	}

}
