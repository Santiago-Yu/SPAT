class n5229696{
    public static HttpsURLConnection createRequest(String feedUrl, String httpMethod, Map<String, String> headers) throws BuzzIOException {
        HttpsURLConnection con;
        try {
            URL url = new URL(feedUrl);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod(httpMethod);
            if (headers != null && !headers.isEmpty()) {
                for (String key : headers.keySet()) {
                    con.setRequestProperty(key, headers.get(key));
                }
            }
        } catch (IOException e) {
            throw new BuzzIOException(e);
        }
        return con;
    }

}