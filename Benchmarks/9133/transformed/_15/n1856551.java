class n1856551 {
	public InputStream open() {
		try {
			if ((url.getProtocol() != null && url.getProtocol().equals("file"))) {
				if (new File(url.toURI()).exists()) {
					inputStream = url.openStream();
				}
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