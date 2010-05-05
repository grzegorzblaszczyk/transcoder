package gbc.i18n;

import org.apache.commons.lang.StringUtils;

public abstract class AbstractTranscoder implements Transcoder {

	public String fromEntitiesToNative(final String input) {
		return transcode(input, 2, 0);
	}

	public String fromNativeToEntities(final String input) {
		return transcode(input, 0, 2);
	}

	public String decode(final String input) {
		String output = input;
		output = transcode(output, 0, 1);
		return output;
	}

	protected abstract String transcode(final String input, final int sourceColumn,
			final int destinationColumn);

	protected String transcode(final String input, String[][] transcodeTable,
			int sourceColumn, int destinationColumn) {
		String output = input;
		for (int i = 0; i < transcodeTable.length; i++) {
			output = StringUtils.replace(output,
					transcodeTable[i][sourceColumn],
					transcodeTable[i][destinationColumn]);
		}
		return output;
	}

}
