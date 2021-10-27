class n5918578{
    public void connect(String method, String data, String urlString, Properties properties, boolean allowredirect) throws Exception {
        if (urlString != null) {
            try {
                url_ = new URL(url_, urlString);
            } catch (Exception e) {
                throw new Exception("Invalid URL");
            }
        }
        try {
            httpURLConnection_ = (HttpURLConnection) url_.openConnection(siteThread_.getProxy());
            httpURLConnection_.setDoInput(true);
            httpURLConnection_.setDoOutput(true);
            httpURLConnection_.setUseCaches(false);
            httpURLConnection_.setRequestMethod(method);
            httpURLConnection_.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            httpURLConnection_.setInstanceFollowRedirects(allowredirect);
            if (properties != null) {
                for (Object propertyKey : properties.keySet()) {
                    String propertyValue = properties.getProperty((String) propertyKey);
                    if (propertyValue.equalsIgnoreCase("Content-Length")) {
                        httpURLConnection_.setFixedLengthStreamingMode(0);
                    }
                    httpURLConnection_.setRequestProperty((String) propertyKey, propertyValue);
                }
            }
            int connectTimeout = httpURLConnection_.getConnectTimeout();
            if (data != null) {
                post(data);
            }
            httpURLConnection_.connect();
        } catch (Exception e) {
            throw new Exception("Connection failed with url " + url_);
        }
    }

}