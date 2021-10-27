class n12853333 {
	public static String getURLContent(String href) throws BuildException {
		String content;
		URL url = null;
		try {
			URL context = new URL("file:" + System.getProperty("user.dir") + "/");
			url = new URL(context, href);
			InputStream is = url.openStream();
			StringBuffer stringBuffer = new StringBuffer();
			InputStreamReader isr = new InputStreamReader(is);
			int len;
			char[] buffer = new char[1024];
			while ((len = isr.read(buffer, 0, 1024)) > 0)
				stringBuffer.append(buffer, 0, len);
			content = stringBuffer.toString();
			isr.close();
		} catch (Exception ex) {
			throw new BuildException("Cannot get content of URL " + href + ": " + ex);
		}
		return content;
	}

}