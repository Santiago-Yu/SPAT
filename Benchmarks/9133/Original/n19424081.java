class n19424081{
    public static String getContent(String url, String code) {
        HttpURLConnection connect = null;
        try {
            URL myurl = new URL(url);
            connect = (HttpURLConnection) myurl.openConnection();
            connect.setConnectTimeout(30000);
            connect.setReadTimeout(30000);
            connect.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; GTB5; .NET CLR 1.1.4322; .NET CLR 2.0.50727; Alexa Toolbar; MAXTHON 2.0)");
            return StringUtil.convertStreamToString(connect.getInputStream(), code);
        } catch (Exception e) {
            slogger.warn(e.getMessage());
        } finally {
            if (connect != null) {
                connect.disconnect();
            }
        }
        slogger.warn("这个没找到" + url);
        return null;
    }

}