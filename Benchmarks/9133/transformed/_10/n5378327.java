class n5378327 {
	public static synchronized Map<String, Object> getURLContentMap(String wwwurl)
			throws IOException, URISyntaxException {
		URI uri = new URI(wwwurl);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		URL url = new URL(uri.toASCIIString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setReadTimeout(10 * 1000);
		HttpURLConnection.setFollowRedirects(true);
		try {
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.2.17) Gecko/20110421 Red Hat/3.6-1.el5_6 Firefox/3.6.17");
			for (String key : conn.getHeaderFields().keySet()) {
				List<String> headerInfo = conn.getHeaderFields().get(key);
				if (headerInfo.size() > 0) {
					resultMap.put(key, headerInfo.get(0));
				}
			}
			String contentType = conn.getContentType();
			ByteArrayOutputStream outstream = new ByteArrayOutputStream();
			if (!(contentType == null || contentType.toLowerCase().contains("text")
					|| contentType.toLowerCase().contains("html"))) {
				return resultMap;
			}
			InputStream instream = conn.getInputStream();
			synchronized (instream) {
				int totalSize = 0;
				int readSize = 0;
				byte[] buffer = new byte[1024];
				byte[] contentByte = null;
				while ((readSize = instream.read(buffer)) > 0) {
					outstream.write(buffer, 0, readSize);
					totalSize += readSize;
					if (totalSize >= MAX_CONTENT_SIZE) {
						contentByte = ("[FAILD] content size is larger than " + MAX_CONTENT_SIZE + " byte.").getBytes();
					}
				}
				if (contentByte == null) {
					contentByte = outstream.toByteArray();
				}
				instream.close();
				outstream.close();
				resultMap.put(contentByteField, contentByte);
			}
		} finally {
		}
		return resultMap;
	}

}