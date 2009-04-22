package gbc.i18n.ua;

import org.apache.commons.lang.StringUtils;

import gbc.i18n.Transcoder;

public class UkrainianTranscoder implements Transcoder {

	private static final String[][] UNICODE_TRANSCODE_TABLE={
	  {"\u0404","E","&#1028;"},
	  {"\u0410","A","&#1040;"},
		{"\u0411","B","&#1041;"},
		{"\u0412","V","&#1042;"},
		{"\u0413","G","&#1043;"},
		{"\u0414","D","&#1044;"},
		{"\u0415","E","&#1045;"},
		{"\u0416","ZH","&#1046;"},
		{"\u0417","Z","&#1047;"},
		{"\u0418","I","&#1048;"},
		{"\u0419","I","&#1049;"},
		{"\u0406","I","&#1030;"},
		{"\u041a","K","&#1050;"},
		{"\u041b","L","&#1051;"},
		{"\u041c","M","&#1052;"},
		{"\u041d","N","&#1053;"},
		{"\u041e","O","&#1054;"},
		{"\u041f","P","&#1055;"},
		{"\u0420","R","&#1056;"},
		{"\u0421","S","&#1057;"},
		{"\u0422","T","&#1058;"},
		{"\u0423","U","&#1059;"},
		{"\u0424","F","&#1060;"},
		{"\u0425","H","&#1061;"},
		{"\u0426","TS","&#1062;"},
		{"\u0427","CH","&#1063;"},
		{"\u0428","SH","&#1064;"},
		{"\u0429","SHCH","&#1065;"},
		{"\u042a","","&#1066;"},
		{"\u042b","Y","&#1067;"},
		{"\u042c","","&#1068;"},
		{"\u042d","E","&#1069;"},
		{"\u042e","U","&#1070;"},
		{"\u042f","A","&#1071;"},
		{"\u0430","a","&#1072;"},
		{"\u0431","b","&#1073;"},
		{"\u0432","v","&#1074;"},
		{"\u0433","g","&#1075;"},
		{"\u0434","d","&#1076;"},
		{"\u0435","e","&#1077;"},
		{"\u0436","zh","&#1078;"},
		{"\u0437","z","&#1079;"},
		{"\u0438","i","&#1080;"},
		{"\u0454","e","&#1108;"},
		{"\u0456","i","&#1110;"},
		{"\u0457","i","&#1111;"},
		{"\u0439","i","&#1081;"},
		{"\u043a","k","&#1082;"},
		{"\u043b","l","&#1083;"},
		{"\u043c","m","&#1084;"},
		{"\u043d","n","&#1085;"},
		{"\u043e","o","&#1086;"},
		{"\u043f","p","&#1087;"},
		{"\u0440","r","&#1088;"},
		{"\u0441","s","&#1089;"},
		{"\u0442","t","&#1090;"},
		{"\u0443","u","&#1091;"},
		{"\u0444","f","&#1092;"},
		{"\u0445","h","&#1093;"},
		{"\u0446","ts","&#1094;"},
		{"\u0447","ch","&#1095;"},
		{"\u0448","sh","&#1096;"},
		{"\u0449","shch","&#1097;"},
		{"\u044a","","&#1098;"},
		{"\u044b","y","&#1099;"},
		{"\u044c","","&#1100;"},
		{"\u044d","e","&#1101;"},
		{"\u044e","u","&#1102"},
		{"\u044f","a","&#1103;"},
		{"\u0490","G","&#1168;"},
		{"\u0491","g","&#1169;"}
	};

	@Override
	public String decode(String input) {
		String output = input;
		output = transcode(output, 0, 1);
		return output;
	}

	@Override
	public String fromNativeToEntities(String input) {
		return transcode(input, 0, 2);
	}


	@Override
	public String fromEntitiesToNative(String input) {
		return transcode(input, 2, 0);
	}

	private String transcode(String output, int sourceColumn, int destinationColumn) {
		for (int i=0; i<UNICODE_TRANSCODE_TABLE.length; i++) {
			output = StringUtils.replace(output, UNICODE_TRANSCODE_TABLE[i][sourceColumn], UNICODE_TRANSCODE_TABLE[i][destinationColumn]);
		}
		return output;
	}

}
