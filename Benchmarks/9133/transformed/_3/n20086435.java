class n20086435 {
	private InputStream createInputStream(String url) throws MalformedURLException, IOException {
		if (!(url.startsWith("classpath://"))) {
			return new URL(url).openStream();
		} else {
			InputStream is = XMLResource.class.getResourceAsStream(url.substring(12));
			if (is == null)
				throw new IOException("Couldn't open stream to [" + url + "]");
			return is;
		}
	}

}