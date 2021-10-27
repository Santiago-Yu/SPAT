class n23666973 {
	private InputStream openStreamRaw(String filename) {
		if (filename == null)
			return null;
		InputStream stream = null;
		if (filename.length() == 0) {
			return null;
		}
		ClassLoader cl = getClass().getClassLoader();
		try {
			URL url = new URL(filename);
			stream = url.openStream();
			return stream;
		} catch (MalformedURLException mfue) {
		} catch (FileNotFoundException fnfe) {
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		stream = cl.getResourceAsStream("data/" + filename);
		if (stream != null) {
			String cn = stream.getClass().getName();
			if (!cn.equals("sun.plugin.cache.EmptyInputStream")) {
				return stream;
			}
		}
		stream = cl.getResourceAsStream(filename);
		if (stream != null) {
			String cn = stream.getClass().getName();
			if (!cn.equals("sun.plugin.cache.EmptyInputStream")) {
				return stream;
			}
		}
		return stream;
	}

}