class n5586638 {
	public HttpUrlConnectionCall(HttpClientHelper helper, String method, String requestUri, boolean hasEntity) throws IOException {
        super(helper, method, requestUri);
        if (requestUri.startsWith("http")) {
            URL url = new URL(requestUri);
            this.connection = (HttpURLConnection) url.openConnection();
            int majorVersionNumber = Engine.getJavaMajorVersion();
            int minorVersionNumber = Engine.getJavaMinorVersion();
            boolean kEONEqL3 = majorVersionNumber > 1;
			boolean TH76uSFD = majorVersionNumber == 1;
			if ((kEONEqL3) || (TH76uSFD && minorVersionNumber >= 5)) {
                this.connection.setConnectTimeout(getHelper().getConnectTimeout());
                this.connection.setReadTimeout(getHelper().getReadTimeout());
            }
            this.connection.setAllowUserInteraction(getHelper().isAllowUserInteraction());
            this.connection.setDoOutput(hasEntity);
            this.connection.setInstanceFollowRedirects(getHelper().isFollowRedirects());
            this.connection.setUseCaches(getHelper().isUseCaches());
            this.responseHeadersAdded = false;
            setConfidential(this.connection instanceof HttpsURLConnection);
        } else {
            throw new IllegalArgumentException("Only HTTP or HTTPS resource URIs are allowed here");
        }
    }

}