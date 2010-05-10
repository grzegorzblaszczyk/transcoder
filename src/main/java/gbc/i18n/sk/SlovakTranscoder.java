package gbc.i18n.sk;


import gbc.i18n.AbstractTranscoder;

public class SlovakTranscoder extends AbstractTranscoder {

	private static final String[][] UNICODE_TRANSCODE_TABLE = {

    {"\u00c1","A","&#193;"},
    {"\u00e1","a","&#225;"},
    {"\u00c4","A","&#196;"},
    {"\u00e4","a","&#228;"},
	  {"\u010c","C","&#268;"},
    {"\u010d","c","&#269;"},
    {"\u010e","D","&#270;"},
    {"\u010f","d","&#271;"},
    {"\u00c9","E","&#201;"},
    {"\u00e9","e","&#233;"},
	  {"\u00cd","I","&#205;"},
	  {"\u00ed","i","&#237;"},
	  {"\u0139","L","&#313;"},
	  {"\u013a","l","&#314;"},
	  {"\u013d","L","&#317;"},
	  {"\u013e","l","&#318;"},
    {"\u013f","L","&#319;"},
    {"\u0140","l","&#320;"},
    {"\u0147","N","&#327;"},
    {"\u0148","n","&#328;"},
    {"\u00d4","O","&#211;"},
    {"\u00f4","o","&#243;"},
	  {"\u0154","R","&#340;"},
		{"\u0155","r","&#341;"},
    {"\u0160","S","&#352;"},
    {"\u0161","s","&#353;"},
    {"\u0164","T","&#356;"},
    {"\u0165","t","&#357;"},
    {"\u00da","U","&#218;"},
    {"\u00fa","u","&#250;"},
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
