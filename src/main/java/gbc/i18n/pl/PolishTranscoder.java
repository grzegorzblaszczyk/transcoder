package gbc.i18n.pl;

import gbc.i18n.AbstractTranscoder;

public class PolishTranscoder extends AbstractTranscoder {

	private static final String[][] UNICODE_TRANSCODE_TABLE = {
		{"\u00d3","O","&#211;"},
		{"\u00f3","o","&#243;"},
		{"\u0104","A","&#260;"},
  	{"\u0105","a","&#261;"},
  	{"\u0106","C","&#262;"},
  	{"\u0107","c","&#263;"},
  	{"\u0118","E","&#280;"},
  	{"\u0119","e","&#281;"},
  	{"\u0141","L","&#321;"},
  	{"\u0142","l","&#322;"},
  	{"\u0143","N","&#323;"},
  	{"\u0144","n","&#324;"},
  	{"\u015a","S","&#346;"},
  	{"\u015b","s","&#347;"},
  	{"\u0179","Z","&#377;"},
  	{"\u017a","z","&#378;"},
  	{"\u017b","Z","&#379;"},
  	{"\u017c","z","&#380;"},
  };

	@Override
	protected String transcode(final String input, int sourceColumn, int destinationColumn) {
		return transcode(input, UNICODE_TRANSCODE_TABLE, sourceColumn, destinationColumn);
	}

}
