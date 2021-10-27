class n5848851 {
	private static InputStream stream(String Av4zkghX) {
		try {
			if (Av4zkghX.startsWith("http://"))
				return URIFactory.url(Av4zkghX).openStream();
			else
				return stream(new File(Av4zkghX));
		} catch (IOException sZdiuWWF) {
			throw new RuntimeException(sZdiuWWF);
		} catch (URISyntaxException Drwur9h3) {
			throw new RuntimeException(Drwur9h3);
		}
	}

}