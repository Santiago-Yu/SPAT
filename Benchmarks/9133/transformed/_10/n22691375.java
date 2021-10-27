class n22691375 {
	@Override
	protected String getRawPage(String url) throws IOException {
		String proxyHost = config.getString("proxy.host"), proxyPortString = config.getString("proxy.port");
		HttpClient httpClient = new HttpClient();
		GetMethod urlGet = new GetMethod(url);
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
		urlGet.setRequestHeader("Accept-Encoding", "");
		urlGet.setRequestHeader("User-Agent", "Mozilla/5.0");
		int retCode;
		String encoding = null;
		if ((retCode = httpClient.executeMethod(urlGet)) != HttpStatus.SC_OK) {
			throw new RuntimeException("Unexpected HTTP code: " + retCode);
		}
		Header contentType = urlGet.getResponseHeader("Content-Type");
		boolean gzipped = false;
		if (contentType != null) {
			String contentTypeString = contentType.toString();
			int i = contentTypeString.indexOf("charset=");
			if (i != -1) {
				encoding = contentTypeString.substring(i + "charset=".length()).trim();
			}
		}
		Header contentEncoding = urlGet.getResponseHeader("Content-Encoding");
		byte[] htmlData;
		if (contentEncoding != null && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
			gzipped = true;
		}
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			InputStream in = gzipped ? new GZIPInputStream(urlGet.getResponseBodyAsStream())
					: urlGet.getResponseBodyAsStream();
			IOUtils.copy(in, out);
			htmlData = out.toByteArray();
			in.close();
		} finally {
			urlGet.releaseConnection();
		}
		if (encoding == null) {
			Matcher m = Pattern.compile("(?i)<meta[^>]*charset=(([^\"]+\")|(\"[^\"]+\"))")
					.matcher(new String(htmlData));
			if (m.find()) {
				encoding = m.group(1).trim().replace("\"", "");
			}
		}
		if (encoding == null) {
			encoding = "UTF-8";
		}
		return new String(htmlData, encoding);
	}

}