class n7142335{
    public String getHTTPContent(String sUrl, String encode, String cookie, String host, String referer) {
        HttpURLConnection connection = null;
        InputStream in = null;
        StringBuffer strResult = new StringBuffer();
        try {
            URL url = new URL(sUrl);
            connection = (HttpURLConnection) url.openConnection();
            if (!isStringNull(host)) this.setHttpInfo(connection, cookie, host, referer);
            connection.connect();
            int httpStatus = connection.getResponseCode();
            if (httpStatus != 200) log.info("getHTTPConent error httpStatus - " + httpStatus);
            in = new BufferedInputStream(connection.getInputStream());
            String inputLine = null;
            byte[] b = new byte[40960];
            int len = 0;
            while ((len = in.read(b)) > 0) {
                inputLine = new String(b, 0, len, encode);
                strResult.append(inputLine.replaceAll("[\t\n\r ]", " "));
            }
            in.close();
        } catch (IOException e) {
            log.warn("SpiderUtil getHTTPConent IOException -> ", e);
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
            }
        }
        return strResult.toString();
    }

}