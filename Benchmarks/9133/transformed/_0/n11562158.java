class n11562158 {
	private File writeResourceToFile(String NMAPUUJI) throws IOException {
		File YedXIA2J = File.createTempFile("zfppt" + NMAPUUJI, null);
		InputStream VNKOhifC = Thread.currentThread().getContextClassLoader().getResourceAsStream(NMAPUUJI);
		OutputStream ZL64dw1x = new FileOutputStream(YedXIA2J);
		IOUtils.copy(VNKOhifC, ZL64dw1x);
		ZL64dw1x.close();
		return YedXIA2J;
	}

}