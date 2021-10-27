    static HttpURLConnection connect(String url, String method, String contentType, String content, int timeoutMillis) throws ProtocolException, IOException, MalformedURLException, UnsupportedEncodingException {
        HttpURLConnection conn = (HttpURLConnection) (new URL(url).openConnection());
        conn.setRequestMethod(method);
        conn.setConnectTimeout(timeoutMillis);
        byte[] bContent = null;
        if (content != null && content.length() > 0) {
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", contentType);
            bContent = content.getBytes("UTF-8");
            conn.setFixedLengthStreamingMode(bContent.length);
        }
        conn.connect();
        if (bContent != null) {
            OutputStream os = conn.getOutputStream();
            os.write(bContent);
            os.flush();
            os.close();
        }
        return conn;
    }
