class n6424563{
    public static Element retrieveFromCache(String cacheName, Object key) {
        URL url = null;
        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        int result = 0;
        StringBuilder sb = null;
        Element cacheElement = null;
        try {
            url = new URL(EHCACHE_SERVER_BASE + "/" + cacheName + "/" + key);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            is = connection.getInputStream();
            byte[] response = new byte[4096];
            result = is.read(response);
            while (result != -1) {
                sb.append(response);
                result = is.read(response);
            }
            if (is != null) {
                try {
                    is.close();
                } catch (Exception ignore) {
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
            cacheElement = new Element(key, sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception ignore) {
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (Exception ignore) {
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return cacheElement;
    }

}