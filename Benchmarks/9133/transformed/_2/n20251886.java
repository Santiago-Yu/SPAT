class n20251886 {
	private void initJarURL() {
		try {
			URL url = getKwantuJarURLInMavenRepo(artifactId, version);
			File tempJarFile = File.createTempFile(artifactId + "-" + version, ".jar");
			OutputStream out = new FileOutputStream(tempJarFile);
			InputStream in = url.openStream();
			int length = 0;
			byte[] bytes = new byte[2048];
			for (; (length = in.read(bytes)) > 0;) {
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