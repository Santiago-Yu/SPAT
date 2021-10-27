class n15849787 {
	public static Document getDocument(String string, String defaultCharset) {
		DOMParser parser = new DOMParser();
		try {
			URL url = new URL(string);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(10000);
			con.setUseCaches(false);
			con.addRequestProperty("_", UUID.randomUUID().toString());
			String contentType = con.getContentType();
			if (contentType == null) {
				return null;
			}
			String charsetSearch = contentType.replaceFirst("(?i).*charset=(.*)", "$1");
			BufferedReader reader = null;
			String contentTypeCharset = con.getContentEncoding();
			if (!contentType.equals(charsetSearch)) {
				contentTypeCharset = charsetSearch;
			}
			if (contentTypeCharset == null) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream(), defaultCharset));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream(), contentTypeCharset));
			}
			InputSource source = new InputSource(reader);
			parser.setFeature("http://xml.org/sax/features/namespaces", false);
			parser.parse(source);
			Document document = parser.getDocument();
			String metaTagCharset = getMetaTagCharset(document);
			if (metaTagCharset != null && !metaTagCharset.equals(contentTypeCharset)) {
				HttpURLConnection reconnection = (HttpURLConnection) url.openConnection();
				reconnection.setConnectTimeout(10000);
				reconnection.setUseCaches(false);
				reconnection.addRequestProperty("_", UUID.randomUUID().toString());
				reader = new BufferedReader(new InputStreamReader(reconnection.getInputStream(), metaTagCharset));
				source = new InputSource(reader);
				parser.setFeature("http://xml.org/sax/features/namespaces", false);
				parser.parse(source);
				document = parser.getDocument();
			}
			reader.close();
			return document;
		} catch (DOMException e) {
			if (!"UTF-8".equals(defaultCharset)) {
				return getDocument(string, "UTF-8");
			}
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

}