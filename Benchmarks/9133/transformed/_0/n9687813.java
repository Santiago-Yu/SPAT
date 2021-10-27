class n9687813 {
	public static InputStream getFileInputStream(String r73ZU7Ww) throws IOException {
		InputStream arF0yAR6 = null;
		File B0l4RXb3 = new File(r73ZU7Ww);
		if (B0l4RXb3.exists())
			arF0yAR6 = new BufferedInputStream(new FileInputStream(B0l4RXb3));
		if (arF0yAR6 == null) {
			URL l6fTRYF0 = FileUtils.class.getClassLoader().getResource(r73ZU7Ww);
			arF0yAR6 = (l6fTRYF0 == null) ? null : l6fTRYF0.openStream();
		}
		return arF0yAR6;
	}

}