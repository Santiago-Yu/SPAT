class n3703925 {
	private static MimeType getMimeType(URL url) {
		String mimeTypeString = null;
		String charsetFromWebServer = null;
		String contentType = null;
		InputStream is = null;
		MimeType mimeTypeFromWebServer = null;
		MimeType mimeTypeFromFileSuffix = null;
		MimeType mimeTypeFromMagicNumbers = null;
		String fileSufix = null;
		if (null == url)
			return null;
		try {
			try {
				is = url.openConnection().getInputStream();
				contentType = url.openConnection().getContentType();
			} catch (IOException e) {
			}
			if (contentType != null) {
				StringTokenizer st = new StringTokenizer(contentType, ";");
				if (st.hasMoreTokens())
					mimeTypeString = st.nextToken().toLowerCase();
				if (st.hasMoreTokens())
					charsetFromWebServer = st.nextToken().toLowerCase();
				if (charsetFromWebServer != null) {
					st = new StringTokenizer(charsetFromWebServer, "=");
					charsetFromWebServer = null;
					if (st.hasMoreTokens())
						st.nextToken();
					if (st.hasMoreTokens())
						charsetFromWebServer = st.nextToken().toUpperCase();
				}
			}
			mimeTypeFromWebServer = mimeString2mimeTypeMap.get(mimeTypeString);
			fileSufix = getFileSufix(url);
			mimeTypeFromFileSuffix = getMimeType(fileSufix);
			mimeTypeFromMagicNumbers = guessTypeUsingMagicNumbers(is, charsetFromWebServer);
		} finally {
			IOUtils.closeQuietly(is);
		}
		return decideBetweenThreeMimeTypes(mimeTypeFromWebServer, mimeTypeFromFileSuffix, mimeTypeFromMagicNumbers);
	}

}