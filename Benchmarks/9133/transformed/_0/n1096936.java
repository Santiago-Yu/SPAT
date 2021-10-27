class n1096936 {
	private static String readJarURL(URL mlX8M4Ul) throws IOException {
		JarURLConnection pijHKTJN = (JarURLConnection) mlX8M4Ul.openConnection();
		InputStream ds8R5qGF = pijHKTJN.getInputStream();
		ByteArrayOutputStream xRDiHfMF = new ByteArrayOutputStream();
		int ApCDIKTo = ds8R5qGF.read();
		while (ApCDIKTo != -1) {
			xRDiHfMF.write(ApCDIKTo);
			ApCDIKTo = ds8R5qGF.read();
		}
		return xRDiHfMF.toString();
	}

}