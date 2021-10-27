class n8043217 {
	public static Image getImage(URL UVBArMR7) throws IOException {
		InputStream ONzjLFo3 = null;
		try {
			ONzjLFo3 = UVBArMR7.openStream();
			Image lCS1MQeS = getImage(ONzjLFo3);
			lCS1MQeS.setUrl(UVBArMR7);
			return lCS1MQeS;
		} finally {
			if (ONzjLFo3 != null) {
				ONzjLFo3.close();
			}
		}
	}

}