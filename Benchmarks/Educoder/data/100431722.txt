    private static RemoteFile getRemoteFile(String url) {
        long size = 0;
        String realUrl = "";
        try {
            HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
            size = conn.getContentLength();
            realUrl = conn.getURL().toString();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        RemoteFile rf = new RemoteFile(size, realUrl);
        return rf;
    }
