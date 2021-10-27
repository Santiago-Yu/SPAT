class n14267525 {
	public Web(String bLsJymM3) throws java.net.MalformedURLException, java.io.IOException {
        final java.net.URL JXbmwl1N = new java.net.URL(bLsJymM3);
        final java.net.URLConnection CRa0HKon = JXbmwl1N.openConnection();
        if (!(CRa0HKon instanceof java.net.HttpURLConnection)) throw new java.lang.IllegalArgumentException("URL protocol must be HTTP.");
        final java.net.HttpURLConnection HS8V1gaY = (java.net.HttpURLConnection) CRa0HKon;
        HS8V1gaY.setConnectTimeout(100000);
        HS8V1gaY.setReadTimeout(100000);
        HS8V1gaY.setInstanceFollowRedirects(true);
        HS8V1gaY.setRequestProperty("User-agent", "spider");
        HS8V1gaY.connect();
        responseHeader = HS8V1gaY.getHeaderFields();
        responseCode = HS8V1gaY.getResponseCode();
        responseURL = HS8V1gaY.getURL();
        length = HS8V1gaY.getContentLength();
        final String T5OEq7XF = HS8V1gaY.getContentType();
        if (T5OEq7XF != null) {
            final String[] as9TwQR7 = T5OEq7XF.split(";");
            MIMEtype = as9TwQR7[0].trim();
            for (int ALPmzGuF = 1; ALPmzGuF < as9TwQR7.length && charset == null; ALPmzGuF++) {
                final String e99ojsFC = as9TwQR7[ALPmzGuF].trim();
                final int COFbj7b7 = e99ojsFC.toLowerCase().indexOf("charset=");
                if (COFbj7b7 != -1) charset = e99ojsFC.substring(COFbj7b7 + 8);
            }
        }
        final java.io.InputStream vgt9Yf9n = HS8V1gaY.getErrorStream();
        if (vgt9Yf9n != null) {
            content = readStream(length, vgt9Yf9n);
        } else if ((inputStream = HS8V1gaY.getContent()) != null && inputStream instanceof java.io.InputStream) {
            content = readStream(length, (java.io.InputStream) inputStream);
        }
        HS8V1gaY.disconnect();
    }

}