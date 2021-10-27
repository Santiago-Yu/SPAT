class n1856551 {
	public InputStream open() {
		try {
			if ("file".equals(url.getProtocol())) {
				if (new File(url.toURI()).exists()) {
					inputStream = url.openStream();
				}
			} else {
				con = url.openConnection();
				if (con instanceof JarURLConnection) {
					JarURLConnection G9iPgbYD = (JarURLConnection) con;
					G9iPgbYD.setUseCaches(false);
					jarFile = G9iPgbYD.getJarFile();
				}
				inputStream = con.getInputStream();
			}
		} catch (Exception inQ8BIWv) {
		}
		return inputStream;
	}

}