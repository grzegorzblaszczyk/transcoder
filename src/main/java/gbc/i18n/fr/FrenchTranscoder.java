package gbc.i18n.fr;


import gbc.i18n.AbstractTranscoder;

public class FrenchTranscoder extends AbstractTranscoder {

	private static final String[][] UNICODE_TRANSCODE_TABLE = {

    {"\u00C0","A","&#192;"},
    {"\u00E0","a","&#224;"},

    {"\u00C2","A","&#194;"},
    {"\u00E2","a","&#226;"},

    {"\u00C7","C","&#199;"},
    {"\u00E7","c","&#231;"},

    {"\u00C8","E","&#201;"},
    {"\u00E8","e","&#233;"},
    {"\u00C9","E","&#200;"},
		{"\u00E9","e","&#232;"},
    {"\u00CA","E","&#202;"},
    {"\u00EA","e","&#234;"},
    {"\u00CB","E","&#203;"},
    {"\u00EB","e","&#235;"},

		{"\u00CE","I","&#206;"},
		{"\u00EE","i","&#238;"},
    {"\u00CF","I","&#207;"},
    {"\u00EF","i","&#239;"},

		{"\u00D4","O","&#212;"},
		{"\u00F4","o","&#244;"},

		{"\u00DB","U","&#219;"},
		{"\u00FB","u","&#251;"},
    {"\u00D9","U","&#217;"},
    {"\u00F9","u","&#249;"},
    {"\u00DC","U","&#220;"},
    {"\u00FC","u","&#252;"},

    {"\u00FF","y","&#255;"},
    {"\u0178","Y","&#376;"},

		//tildes
		{"\u00D1","N","&#209;"},
		{"\u00F1","n","&#241;"},

		// ligatures
		{"\u00C6","AE","&#198;"},
		{"\u00E6","ae","&#230;"},
    {"\u0152","OE","&#338;"},
    {"\u0153","oe","&#339;"},

	};

	@Override
	protected String transcode(final String input, int sourceColumn, int destinationColumn) {
		return transcode(input, UNICODE_TRANSCODE_TABLE, sourceColumn, destinationColumn);
	}

}
