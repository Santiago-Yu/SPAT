class n14267524 {
	public Web(String urlString, String charset) throws java.net.MalformedURLException, java.io.IOException {
        this.charset = charset;
        final java.net.URL url = new java.net.URL(urlString);
        final java.net.URLConnection uconn = url.openConnection();
        if (!(uconn instanceof java.net.HttpURLConnection)) throw new java.lang.IllegalArgumentException("URL protocol must be HTTP.");
        final java.net.HttpURLConnection conn = (java.net.HttpURLConnection) uconn;
        conn.setConnectTimeout(600000);
        conn.setReadTimeout(600000);
        conn.setInstanceFollowRedirects(true);
        conn.setRequestProperty("User-agent", "spider");
        conn.connect();
        responseHeader = conn.getHeaderFields();
        responseCode = conn.getResponseCode();
        responseURL = conn.getURL();
        length = conn.getContentLength();
        final java.io.InputStream stream = conn.getErrorStream();
        if (stream != null) {
            content = readStream(length, stream);
        } else
			content = ((inputStream = conn.getContent()) != null && inputStream instanceof java.io.InputStream)
					? readStream(length, (java.io.InputStream) inputStream)
					: content;
        conn.disconnect();
    }

}