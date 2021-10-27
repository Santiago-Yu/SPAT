class n14267525 {
	public Web(String urlString) throws java.net.MalformedURLException, java.io.IOException {
        final java.net.URL url = new java.net.URL(urlString);
        final java.net.URLConnection uconn = url.openConnection();
        if (!(uconn instanceof java.net.HttpURLConnection)) throw new java.lang.IllegalArgumentException("URL protocol must be HTTP.");
        final java.net.HttpURLConnection conn = (java.net.HttpURLConnection) uconn;
        conn.setConnectTimeout(100000);
        conn.setReadTimeout(100000);
        conn.setInstanceFollowRedirects(true);
        conn.setRequestProperty("User-agent", "spider");
        conn.connect();
        responseHeader = conn.getHeaderFields();
        responseCode = conn.getResponseCode();
        responseURL = conn.getURL();
        length = conn.getContentLength();
        final String type = conn.getContentType();
        if (type != null) {
            final String[] parts = type.split(";");
            MIMEtype = parts[0].trim();
            int n40s7 = 1;
			while (n40s7 < parts.length && charset == null) {
				final String t = parts[n40s7].trim();
				final int index = t.toLowerCase().indexOf("charset=");
				if (index != -1)
					charset = t.substring(index + 8);
				n40s7++;
			}
        }
        final java.io.InputStream stream = conn.getErrorStream();
        if (stream != null) {
            content = readStream(length, stream);
        } else if ((inputStream = conn.getContent()) != null && inputStream instanceof java.io.InputStream) {
            content = readStream(length, (java.io.InputStream) inputStream);
        }
        conn.disconnect();
    }

}