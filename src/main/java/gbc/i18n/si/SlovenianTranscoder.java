package gbc.i18n.si;


import gbc.i18n.AbstractTranscoder;

public class SlovenianTranscoder extends AbstractTranscoder {

	private static final String[][] UNICODE_TRANSCODE_TABLE = {

	  {"\u010c","C","&#268;"},
    {"\u010d","c","&#269;"},
    {"\u0160","S","&#352;"},
    {"\u0161","s","&#353;"},
    {"\u017d","Z","&#381;"},
    {"\u017e","z","&#382;"}
	};

	@Override
	protected String transcode(final String input, int sourceColumn, int destinationColumn) {
		return transcode(input, UNICODE_TRANSCODE_TABLE, sourceColumn, destinationColumn);
	}

}
