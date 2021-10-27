class n22691375 {
	@Override
	protected String getRawPage(String url) throws IOException {
		HttpClient httpClient = new HttpClient();
		String proxyHost = config.getString("proxy.host"), proxyPortString = config.getString("proxy.port");
		if (proxyHost != null && proxyPortString != null) {
			int proxyPort = -1;
			try {
				proxyPort = Integer.parseInt(proxyPortString);
			} catch (NumberFormatException e) {
			}
			if (proxyPort != -1) {
				httpClient.getHostConfiguration().setProxy(proxyHost, proxyPort);
			}
		}
		GetMethod urlGet = new GetMethod(url);
		urlGet.setRequestHeader("Accept-Encoding", "");
		urlGet.setRequestHeader("User-Agent", "Mozilla/5.0");
		int retCode;
		if ((retCode = httpClient.executeMethod(urlGet)) != HttpStatus.SC_OK) {
			throw new RuntimeException("Unexpected HTTP code: " + retCode);
		}
		String encoding = null;
		Header contentType = urlGet.getResponseHeader("Content-Type");
		if (contentType != null) {
			String contentTypeString = contentType.toString();
			int i = contentTypeString.indexOf("charset=");
			encoding = (i != -1) ? contentTypeString.substring(i + "charset=".length()).trim() : encoding;
		}
		boolean gzipped = false;
		Header contentEncoding = urlGet.getResponseHeader("Content-Encoding");
		gzipped = (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) ? true : gzipped;
		byte[] htmlData;
		try {
			InputStream in = gzipped ? new GZIPInputStream(urlGet.getResponseBodyAsStream())
					: urlGet.getResponseBodyAsStream();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			IOUtils.copy(in, out);
			htmlData = out.toByteArray();
			in.close();
		} finally {
			urlGet.releaseConnection();
		}
		if (encoding == null) {
			Matcher m = Pattern.compile("(?i)<meta[^>]*charset=(([^\"]+\")|(\"[^\"]+\"))")
					.matcher(new String(htmlData));
			encoding = (m.find()) ? m.group(1).trim().replace("\"", "") : encoding;
		}
		encoding = (encoding == null) ? "UTF-8" : encoding;
		return new String(htmlData, encoding);
	}

}