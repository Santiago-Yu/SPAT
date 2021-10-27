class n16190704{
    public static String exchangeForSessionToken(String protocol, String domain, String onetimeUseToken, PrivateKey key) throws IOException, GeneralSecurityException, AuthenticationException {
        String sessionUrl = getSessionTokenUrl(protocol, domain);
        URL url = new URL(sessionUrl);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        String header = formAuthorizationHeader(onetimeUseToken, key, url, "GET");
        httpConn.setRequestProperty("Authorization", header);
        if (httpConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new AuthenticationException(httpConn.getResponseCode() + ": " + httpConn.getResponseMessage());
        }
        String body = CharStreams.toString(new InputStreamReader(httpConn.getInputStream(), Charsets.ISO_8859_1));
        Map<String, String> parsedTokens = StringUtil.string2Map(body, "\n", "=", true);
        parsedTokens = StringUtil.lowercaseKeys(parsedTokens);
        return parsedTokens.get("token");
    }

}