package gbc.i18n.is;


import gbc.i18n.AbstractTranscoder;

public class IcelandicTranscoder extends AbstractTranscoder {

	private static final String[][] UNICODE_TRANSCODE_TABLE = {

    // ligatures
    {"\u00C6","AE","&#198;"},
    {"\u00E6","ae","&#230;"},
    
    {"\u00c1","A","&#193;"},
    {"\u00e1","a","&#225;"},
    {"\u00d0","Eth","&ETH;"},
    {"\u00f0","eth","&eth;"},
    {"\u00c9","E","&#201;"},
    {"\u00e9","e","&#233;"},
    {"\u00de","Th","&THORN;"},
    {"\u00fe","th","&#222;"},
    {"\u00cd","I","&#205;"},
    {"\u00ed","i","&#237;"},
    {"\u00d3","O","&#211;"},
    {"\u00f3","o","&#243;"},
    {"\u00d6","Oe","&#214;"},
    {"\u00f6","oe","&#246;"},
    {"\u00da","U","&#218;"},
    {"\u00fa","u","&#250;"},
    {"\u00dd","Y","&#221;"},
    {"\u00fd","y","&#253;"},
	};

	@Override
	protected String transcode(final String input, int sourceColumn, int destinationColumn) {
		return transcode(input, UNICODE_TRANSCODE_TABLE, sourceColumn, destinationColumn);
	}

}
