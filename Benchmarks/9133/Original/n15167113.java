class n15167113{
    public static void doHttpPost(String urlName, byte[] data, String contentType, String cookieData) throws InteropException {
        URL url = getAccessURL(urlName);
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Cookie", cookieData);
            connection.setRequestProperty("Content-type", contentType);
            connection.setRequestProperty("Content-length", "" + data.length);
            OutputStream stream = connection.getOutputStream();
            stream.write(data);
            stream.flush();
            stream.close();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            inputStream.close();
        } catch (IOException ex) {
            throw new InteropException("Error POSTing to " + urlName, ex);
        }
    }

}