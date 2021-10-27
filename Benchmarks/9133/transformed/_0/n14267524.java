class n14267524 {
	public Web(String EGhINcnY, String ySOIZSml) throws java.net.MalformedURLException, java.io.IOException {
        this.charset = ySOIZSml;
        final java.net.URL JZUMsz15 = new java.net.URL(EGhINcnY);
        final java.net.URLConnection fpaQCD3o = JZUMsz15.openConnection();
        if (!(fpaQCD3o instanceof java.net.HttpURLConnection)) throw new java.lang.IllegalArgumentException("URL protocol must be HTTP.");
        final java.net.HttpURLConnection YdYrJrI8 = (java.net.HttpURLConnection) fpaQCD3o;
        YdYrJrI8.setConnectTimeout(600000);
        YdYrJrI8.setReadTimeout(600000);
        YdYrJrI8.setInstanceFollowRedirects(true);
        YdYrJrI8.setRequestProperty("User-agent", "spider");
        YdYrJrI8.connect();
        responseHeader = YdYrJrI8.getHeaderFields();
        responseCode = YdYrJrI8.getResponseCode();
        responseURL = YdYrJrI8.getURL();
        length = YdYrJrI8.getContentLength();
        final java.io.InputStream d6a9iffY = YdYrJrI8.getErrorStream();
        if (d6a9iffY != null) {
            content = readStream(length, d6a9iffY);
        } else if ((inputStream = YdYrJrI8.getContent()) != null && inputStream instanceof java.io.InputStream) {
            content = readStream(length, (java.io.InputStream) inputStream);
        }
        YdYrJrI8.disconnect();
    }

}