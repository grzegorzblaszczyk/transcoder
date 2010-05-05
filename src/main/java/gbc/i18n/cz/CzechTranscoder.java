package gbc.i18n.cz;


import gbc.i18n.AbstractTranscoder;

public class CzechTranscoder extends AbstractTranscoder {

	private static final String[][] UNICODE_TRANSCODE_TABLE = {

    {"\u00c1","A","&#193;"},
    {"\u00e1","a","&#225;"},
	  {"\u010c","C","&#268;"},
    {"\u010d","c","&#269;"},
    {"\u010e","D","&#270;"},
    {"\u010f","d","&#271;"},
    {"\u00c9","E","&#201;"},
    {"\u00e9","e","&#233;"},
    {"\u011a","E","&#282;"},
    {"\u011b","e","&#283;"},
	  {"\u00cd","I","&#205;"},
	  {"\u00ed","i","&#237;"},
    {"\u0147","N","&#327;"},
    {"\u0148","n","&#328;"},
    {"\u00d3","O","&#211;"},
    {"\u00f3","o","&#243;"},
	  {"\u0158","R","&#344;"},
		{"\u0159","r","&#345;"},
    {"\u0160","S","&#352;"},
    {"\u0161","s","&#353;"},
    {"\u0164","T","&#356;"},
    {"\u0165","t","&#357;"},
    {"\u00da","U","&#218;"},
    {"\u00fa","u","&#250;"},
    {"\u016e","U","&#366;"},
    {"\u016f","u","&#367;"},
    {"\u00dd","Y","&#221;"},
    {"\u00fd","y","&#253;"},
    {"\u017d","Z","&#381;"},
    {"\u017e","z","&#382;"}

	};

	@Override
	protected String transcode(final String input, int sourceColumn, int destinationColumn) {
		return transcode(input, UNICODE_TRANSCODE_TABLE, sourceColumn, destinationColumn);
	}

}
