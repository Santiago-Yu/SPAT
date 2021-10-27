class n22842674{
    private byte[] getImage(String urlpath) throws Exception {
        URL url = new URL(urlpath);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(6 * 1000);
        if (conn.getResponseCode() == 200) {
            InputStream inputStream = conn.getInputStream();
            return readStream(inputStream);
        }
        return null;
    }

}