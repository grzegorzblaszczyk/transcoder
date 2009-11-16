package gbc.i18n.es;


import gbc.i18n.AbstractTranscoder;

public class SpanishTranscoder extends AbstractTranscoder {

	private static final String[][] UNICODE_TRANSCODE_TABLE={

		//accent acutes
		{"\u00C1","A","&#193;"},
		{"\u00E1","a","&#225;"},
		{"\u00C9","E","&#201;"},
		{"\u00E9","e","&#233;"},
		{"\u00CD","I","&#204;"},
		{"\u00ED","i","&#237;"},
		{"\u00D3","O","&#211;"},
		{"\u00F3","o","&#243;"},
		{"\u00D9","U","&#217;"},
		{"\u00DA","U","&#218;"},
		{"\u00F9","u","&#249;"},
		{"\u00FA","u","&#250;"},

		//umlauts
		{"\u00CF","I","&#207;"},
		{"\u00EF","i","&#239;"},
		{"\u00DC","U","&#220;"},
		{"\u00FC","u","&#252;"},

		//tildes
		{"\u00D1","N","&#209;"},
		{"\u00F1","n","&#241;"},

		{"\u00A1","!","&#161;"},
		{"\u00BF","?","&#191;"},

	};

	@Override
	protected String transcode(final String input, int sourceColumn, int destinationColumn) {
		return transcode(input, UNICODE_TRANSCODE_TABLE, sourceColumn, destinationColumn);
	}

}
