class n7003929 {
	public URLConnection openConnection(String string) throws ParserException {
		final String prefix = "file://localhost", resource;
		URL url;
		StringBuffer buffer;
		URLConnection ret;
		try {
			url = new URL(fixSpaces(string));
			ret = openConnection(url);
		} catch (MalformedURLException murle) {
			try {
				File file = new File(string);
				resource = file.getCanonicalPath();
				buffer = new StringBuffer(prefix.length() + resource.length());
				buffer.append(prefix);
				if (!resource.startsWith("/"))
					buffer.append("/");
				buffer.append(resource);
				url = new URL(fixSpaces(buffer.toString()));
				ret = openConnection(url);
			} catch (MalformedURLException murle2) {
				String msg = "Error in opening a connection to " + string;
				ParserException ex = new ParserException(msg, murle2);
				throw ex;
			} catch (IOException ioe) {
				String msg = "Error in opening a connection to " + string;
				ParserException ex = new ParserException(msg, ioe);
				throw ex;
			}
		}
		return (ret);
	}

}