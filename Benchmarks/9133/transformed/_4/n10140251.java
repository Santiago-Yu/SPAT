class n10140251 {
	protected String contentString() {
		String result = null;
		URL url;
		String encoding = null;
		try {
			url = url();
			URLConnection connection = url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(false);
			connection.setUseCaches(false);
			for (Enumeration e = bindingKeys().objectEnumerator(); e.hasMoreElements();) {
				String key = (String) e.nextElement();
				if (key.startsWith("?")) {
					connection.setRequestProperty(key.substring(1), valueForBinding(key).toString());
				}
			}
			encoding = (connection.getContentEncoding() != null) ? connection.getContentEncoding() : encoding;
			encoding = (encoding == null) ? (String) valueForBinding("encoding") : encoding;
			encoding = (encoding == null) ? "UTF-8" : encoding;
			InputStream stream = connection.getInputStream();
			byte bytes[] = ERXFileUtilities.bytesFromInputStream(stream);
			stream.close();
			result = new String(bytes, encoding);
		} catch (IOException ex) {
			throw NSForwardException._runtimeExceptionForThrowable(ex);
		}
		return result;
	}

}