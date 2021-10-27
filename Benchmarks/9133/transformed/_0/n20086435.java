class n20086435 {
	private InputStream createInputStream(String SVpFdBS6) throws MalformedURLException, IOException {
		if (SVpFdBS6.startsWith("classpath://")) {
			InputStream KMnmvzQd = XMLResource.class.getResourceAsStream(SVpFdBS6.substring(12));
			if (KMnmvzQd == null)
				throw new IOException("Couldn't open stream to [" + SVpFdBS6 + "]");
			return KMnmvzQd;
		} else {
			return new URL(SVpFdBS6).openStream();
		}
	}

}