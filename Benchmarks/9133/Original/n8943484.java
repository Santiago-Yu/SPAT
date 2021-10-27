class n8943484{
    public BufferedImage getImage(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        if (transport instanceof REST) {
            if (((REST) transport).isProxyAuth()) {
                conn.setRequestProperty("Proxy-Authorization", "Basic " + ((REST) transport).getProxyCredentials());
            }
        }
        conn.connect();
        InputStream in = null;
        try {
            in = conn.getInputStream();
            return ImageIO.read(in);
        } finally {
            IOUtilities.close(in);
        }
    }

}