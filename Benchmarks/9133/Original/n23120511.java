class n23120511{
    private static final String getResult(String url, String postData) throws MalformedURLException, IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        if (!postData.equals("null")) {
            postData = postData.substring(1, postData.length() - 1);
            connection.setDoOutput(true);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            writer.write(postData);
            writer.flush();
        }
        InputStreamReader reader = new InputStreamReader(connection.getInputStream());
        int i;
        StringBuffer buffer = new StringBuffer();
        while ((i = reader.read()) != -1) {
            buffer.append((char) i);
        }
        reader.close();
        String response = buffer.toString().trim();
        response = StringUtilities.replaceAll(response, "\r\n", "\\r\\n");
        response = StringUtilities.replaceAll(response, "\"", "\\\"");
        return "\"" + response + "\"";
    }

}