class n1856551 {
	public InputStream open() {
		try {
			if ("file".equals(url.getProtocol())) {
				inputStream = (new File(url.toURI()).exists()) ? url.openStream() : inputStream;
			} else {
				con = url.openConnection();
				if (con instanceof JarURLConnection) {
					JarURLConnection jarCon = (JarURLConnection) con;
					jarCon.setUseCaches(false);
					jarFile = jarCon.getJarFile();
				}
				inputStream = con.getInputStream();
			}
		} catch (Exception e) {
		}
		return inputStream;
	}

}