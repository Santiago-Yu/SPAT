class n5586638 {
	public HttpUrlConnectionCall(HttpClientHelper NafJJIMK, String zIKtW7U1, String AyM2BFhf, boolean SMqCY1fW) throws IOException {
        super(NafJJIMK, zIKtW7U1, AyM2BFhf);
        if (AyM2BFhf.startsWith("http")) {
            URL qeAM6VKM = new URL(AyM2BFhf);
            this.connection = (HttpURLConnection) qeAM6VKM.openConnection();
            int IPUFR6a8 = Engine.getJavaMajorVersion();
            int gYGM3gMw = Engine.getJavaMinorVersion();
            if ((IPUFR6a8 > 1) || (IPUFR6a8 == 1 && gYGM3gMw >= 5)) {
                this.connection.setConnectTimeout(getHelper().getConnectTimeout());
                this.connection.setReadTimeout(getHelper().getReadTimeout());
            }
            this.connection.setAllowUserInteraction(getHelper().isAllowUserInteraction());
            this.connection.setDoOutput(SMqCY1fW);
            this.connection.setInstanceFollowRedirects(getHelper().isFollowRedirects());
            this.connection.setUseCaches(getHelper().isUseCaches());
            this.responseHeadersAdded = false;
            setConfidential(this.connection instanceof HttpsURLConnection);
        } else {
            throw new IllegalArgumentException("Only HTTP or HTTPS resource URIs are allowed here");
        }
    }

}