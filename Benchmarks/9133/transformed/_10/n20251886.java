class n20251886 {
	private void initJarURL() {
		try {
			URL url = getKwantuJarURLInMavenRepo(artifactId, version);
			File tempJarFile = File.createTempFile(artifactId + "-" + version, ".jar");
			InputStream in = url.openStream();
			OutputStream out = new FileOutputStream(tempJarFile);
			byte[] bytes = new byte[2048];
			int length = 0;
			while ((length = in.read(bytes)) > 0) {
				out.write(bytes, 0, length);
			}
			in.close();
			out.close();
			jarURL = tempJarFile.toURI().toURL();
		} catch (IOException ex) {
			throw new KwantuFaultException(ex);
		}
	}

}