class n21013026 {
	private InputStream getPageStream(String yARs78vw) throws MalformedURLException, IOException {
		URL kDS3avWW = new URL(baseUrl + yARs78vw + "&rhtml=no");
		URLConnection PowKmbiM = kDS3avWW.openConnection();
		PowKmbiM.connect();
		InputStream FA3uzU45 = PowKmbiM.getInputStream();
		BufferedInputStream FMQYhL6G = new BufferedInputStream(FA3uzU45);
		return FMQYhL6G;
	}

}