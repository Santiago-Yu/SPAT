class n2161862{
    public WebFileInputStream(URL url, String userAgent) throws IOException {
        final java.net.URLConnection uconn = url.openConnection();
        if (!(uconn instanceof java.net.HttpURLConnection)) {
            throw new java.lang.IllegalArgumentException("URL protocol must be HTTP: " + url.toExternalForm());
        }
        final java.net.HttpURLConnection conn = (java.net.HttpURLConnection) uconn;
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(10000);
        conn.setInstanceFollowRedirects(true);
        conn.setRequestProperty("User-agent", userAgent);
        conn.connect();
        responseHeader = conn.getHeaderFields();
        responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            if (log.isDebugEnabled()) {
                log.debug(getErrors(conn));
            }
            if (responseCode == 404) {
                throw new IOException(MessageFormat.format(Messages.getString("WebFileInputStream.ERROR_404"), url.toExternalForm()));
            } else if (responseCode == 500) {
                throw new IOException(MessageFormat.format(Messages.getString("WebFileInputStream.ERROR_500"), url.toExternalForm()));
            } else if (responseCode == 403) {
                throw new IOException(MessageFormat.format(Messages.getString("WebFileInputStream.ERROR_403"), url.toExternalForm()));
            } else {
                throw new IOException(MessageFormat.format(Messages.getString("WebFileInputStream.ERROR_OTHER"), url.toExternalForm(), responseCode));
            }
        }
        final String type = conn.getContentType();
        if (type != null) {
            final String[] parts = type.split(";");
            MIMEtype = parts[0].trim();
            for (int i = 1; i < parts.length && charset == null; i++) {
                final String t = parts[i].trim();
                final int index = t.toLowerCase().indexOf("charset=");
                if (index != -1) {
                    charset = t.substring(index + 8);
                }
            }
        }
        Object c = conn.getContent();
        if (c instanceof InputStream) {
            content = (InputStream) c;
        } else {
            content = conn.getInputStream();
        }
    }

}