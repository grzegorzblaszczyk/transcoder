package gbc.i18n.ro;

import gbc.i18n.AbstractTranscoder;

public class RomanianTranscoder extends AbstractTranscoder {

	private static final String[][] UNICODE_TRANSCODE_TABLE= {
	  {"\u00c2","A","&#194;"},
	  {"\u00e2","a","&#226;"},
		{"\u0102","A","&#258;"},
		{"\u0103","a","&#259;"},
		{"\u00ce","I","&#206;"},
		{"\u00ee","i","&#238;"},
		{"\u015e","S","&#350;"},
		{"\u015f","s","&#351;"},
		{"\u0162","T","&#354;"},
		{"\u0163","T","&#355;"},
		{"\u0218","S","&#536;"},
		{"\u0219","s","&#537;"},
		{"\u021a","T","&#538;"},
		{"\u021b","t","&#539;"}
	};

	@Override
	protected String transcode(final String input, int sourceColumn, int destinationColumn) {
		return transcode(input, UNICODE_TRANSCODE_TABLE, sourceColumn, destinationColumn);
	}


}
