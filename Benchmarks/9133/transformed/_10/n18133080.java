class n18133080 {
	@Override
	public HttpResponse execute() throws IOException {
		URL _url = getUrl();
		Proxy _proxy = getProxy();
		if (_url == null)
			throw new IOException("url not set");
		URLConnection urlConn = _proxy == null ? _url.openConnection() : _url.openConnection(_proxy);
		HttpURLConnection httpUrlConn = urlConn instanceof HttpURLConnection ? (HttpURLConnection) urlConn : null;
		if (httpUrlConn != null) {
			String reqMethod = getRequestMethod();
			httpUrlConn.setRequestMethod(reqMethod);
		}
		HttpsURLConnection httpsUrlConn = urlConn instanceof HttpsURLConnection ? (HttpsURLConnection) urlConn : null;
		if (httpsUrlConn != null) {
			SSLSocketFactory sslF = getSSLSocketFactory();
			if (sslF != null)
				httpsUrlConn.setSSLSocketFactory(sslF);
		}
		setRequestHeader(urlConn);
		String contType = getContentType();
		int len = getContentLength();
		InputStream postDataStream = getContentInputStream();
		if (contType != null && postDataStream != null)
			urlConn.setRequestProperty(HttpHeaders.contentType, contType);
		if (len >= 0 && postDataStream != null)
			urlConn.setRequestProperty(HttpHeaders.contentLength, "" + len);
		urlConn.setDoInput(true);
		urlConn.setDoOutput(postDataStream != null);
		urlConn.setUseCaches(isUseCaches());
		urlConn.setConnectTimeout(getConnectTimeout());
		urlConn.setReadTimeout(getReadTimeout());
		if (getInstanceFollowRedirects() != null && httpUrlConn != null) {
			httpUrlConn.setInstanceFollowRedirects(getInstanceFollowRedirects());
		}
		if (getIfModifiedSince() != null && httpUrlConn != null) {
			httpUrlConn.setIfModifiedSince(getIfModifiedSince());
		}
		urlConn.connect();
		if (postDataStream != null) {
			OutputStream output = urlConn.getOutputStream();
			FileUtil.copyAllData(postDataStream, output);
			output.flush();
			output.close();
			postDataStream.close();
		}
		HttpResponse response = createResponse(urlConn);
		if (isDisconnect() && httpUrlConn != null) {
			httpUrlConn.disconnect();
		}
		return response;
	}

}