package gbc.i18n.de;


import gbc.i18n.AbstractTranscoder;

public class GermanTranscoder extends AbstractTranscoder {
	
	private static final String[][] UNICODE_TRANSCODE_TABLE={
		{"\u00C4","Ae","&#196;"},
		{"\u00E4","ae","&#228;"},
		{"\u00D6","Oe","&#214;"},
		{"\u00F6","oe","&#246;"},
		{"\u00DC","Ue","&#220;"},
		{"\u00FC","ue","&#252;"},
		{"\u00DF","ss","&#223;"},
	};

	@Override
	protected String transcode(final String input, int sourceColumn, int destinationColumn) {
		return transcode(input, UNICODE_TRANSCODE_TABLE, sourceColumn, destinationColumn);
	}

}
