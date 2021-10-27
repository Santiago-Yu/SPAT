class n3703925 {
	private static MimeType getMimeType(URL url) {
		String mimeTypeString = null;
		String charsetFromWebServer = null;
		InputStream is = null;
		String contentType = null;
		MimeType mimeTypeFromFileSuffix = null;
		MimeType mimeTypeFromWebServer = null;
		String fileSufix = null;
		MimeType mimeTypeFromMagicNumbers = null;
		if (url == null)
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
					if (st.hasMoreTokens())
						st.nextToken();
					charsetFromWebServer = null;
					if (st.hasMoreTokens())
						charsetFromWebServer = st.nextToken().toUpperCase();
				}
			}
			mimeTypeFromWebServer = mimeString2mimeTypeMap.get(mimeTypeString);
			fileSufix = getFileSufix(url);
			mimeTypeFromMagicNumbers = guessTypeUsingMagicNumbers(is, charsetFromWebServer);
			mimeTypeFromFileSuffix = getMimeType(fileSufix);
		} finally {
			IOUtils.closeQuietly(is);
		}
		return decideBetweenThreeMimeTypes(mimeTypeFromWebServer, mimeTypeFromFileSuffix, mimeTypeFromMagicNumbers);
	}

}