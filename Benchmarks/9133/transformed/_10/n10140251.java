class n10140251 {
	protected String contentString() {
		URL url;
		String result = null;
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
			if (connection.getContentEncoding() != null) {
				encoding = connection.getContentEncoding();
			}
			if (encoding == null) {
				encoding = (String) valueForBinding("encoding");
			}
			InputStream stream = connection.getInputStream();
			if (encoding == null) {
				encoding = "UTF-8";
			}
			byte bytes[] = ERXFileUtilities.bytesFromInputStream(stream);
			stream.close();
			result = new String(bytes, encoding);
		} catch (IOException ex) {
			throw NSForwardException._runtimeExceptionForThrowable(ex);
		}
		return result;
	}

}