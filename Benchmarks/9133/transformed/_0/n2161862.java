class n2161862 {
	public WebFileInputStream(URL hGCB9iDX, String lMsIQHgw) throws IOException {
        final java.net.URLConnection Q4iF4w27 = hGCB9iDX.openConnection();
        if (!(Q4iF4w27 instanceof java.net.HttpURLConnection)) {
            throw new java.lang.IllegalArgumentException("URL protocol must be HTTP: " + hGCB9iDX.toExternalForm());
        }
        final java.net.HttpURLConnection dR9dnFOa = (java.net.HttpURLConnection) Q4iF4w27;
        dR9dnFOa.setConnectTimeout(10000);
        dR9dnFOa.setReadTimeout(10000);
        dR9dnFOa.setInstanceFollowRedirects(true);
        dR9dnFOa.setRequestProperty("User-agent", lMsIQHgw);
        dR9dnFOa.connect();
        responseHeader = dR9dnFOa.getHeaderFields();
        responseCode = dR9dnFOa.getResponseCode();
        if (responseCode != 200) {
            if (log.isDebugEnabled()) {
                log.debug(getErrors(dR9dnFOa));
            }
            if (responseCode == 404) {
                throw new IOException(MessageFormat.format(Messages.getString("WebFileInputStream.ERROR_404"), hGCB9iDX.toExternalForm()));
            } else if (responseCode == 500) {
                throw new IOException(MessageFormat.format(Messages.getString("WebFileInputStream.ERROR_500"), hGCB9iDX.toExternalForm()));
            } else if (responseCode == 403) {
                throw new IOException(MessageFormat.format(Messages.getString("WebFileInputStream.ERROR_403"), hGCB9iDX.toExternalForm()));
            } else {
                throw new IOException(MessageFormat.format(Messages.getString("WebFileInputStream.ERROR_OTHER"), hGCB9iDX.toExternalForm(), responseCode));
            }
        }
        final String ZTbiFarf = dR9dnFOa.getContentType();
        if (ZTbiFarf != null) {
            final String[] kM05Z5E3 = ZTbiFarf.split(";");
            MIMEtype = kM05Z5E3[0].trim();
            for (int nMvAz6fg = 1; nMvAz6fg < kM05Z5E3.length && charset == null; nMvAz6fg++) {
                final String BQQpCRkC = kM05Z5E3[nMvAz6fg].trim();
                final int JP3Fs7RH = BQQpCRkC.toLowerCase().indexOf("charset=");
                if (JP3Fs7RH != -1) {
                    charset = BQQpCRkC.substring(JP3Fs7RH + 8);
                }
            }
        }
        Object wq1aW73g = dR9dnFOa.getContent();
        if (wq1aW73g instanceof InputStream) {
            content = (InputStream) wq1aW73g;
        } else {
            content = dR9dnFOa.getInputStream();
        }
    }

}