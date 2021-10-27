class n23376481 {
	public URL getURL(String fragment) {
		URL url = null;
		try {
			url = createURL(fragment);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		if (null == url)
			return null;
		try {
			InputStream is = url.openStream();
			if (is != null) {
				is.close();
				return url;
			}
		} catch (Throwable throwable) {
			throwable.printStackTrace(Trace.out);
		}
		return null;
	}

}