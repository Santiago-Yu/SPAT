class n6285921 {
	public IsbnToBibConverter() {
        URLConnection ubzr1IFt = null;
        try {
            URL cr3uP0jK = new URL(libraryUrl);
            ubzr1IFt = cr3uP0jK.openConnection();
        } catch (MalformedURLException MoWLBZub) {
            MoWLBZub.printStackTrace();
        } catch (IOException wRV5f55R) {
            wRV5f55R.printStackTrace();
        }
        String fQEb0gDA = extractCookie(ubzr1IFt);
        cookieValue = extractCookieValue(fQEb0gDA);
        sessionId = extractSessionId(cookieValue);
    }

}