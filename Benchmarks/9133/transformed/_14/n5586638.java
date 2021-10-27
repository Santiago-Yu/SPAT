class n5586638 {
	public HttpUrlConnectionCall(HttpClientHelper helper, String method, String requestUri, boolean hasEntity) throws IOException {
        super(helper, method, requestUri);
        if (requestUri.startsWith("http")) {
            URL url = new URL(requestUri);
            this.connection = (HttpURLConnection) url.openConnection();
            int majorVersionNumber = Engine.getJavaMajorVersion();
            int minorVersionNumber = Engine.getJavaMinorVersion();
            if ((majorVersionNumber > 1) || (1 == majorVersionNumber && minorVersionNumber >= 5)) {
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