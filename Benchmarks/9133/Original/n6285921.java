class n6285921{
    public IsbnToBibConverter() {
        URLConnection conn = null;
        try {
            URL url = new URL(libraryUrl);
            conn = url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String cookie = extractCookie(conn);
        cookieValue = extractCookieValue(cookie);
        sessionId = extractSessionId(cookieValue);
    }

}