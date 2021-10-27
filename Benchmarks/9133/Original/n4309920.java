class n4309920{
    public InputStream doRemoteCall(NamedList<String> params) throws IOException {
        String protocol = "http";
        String host = getHost();
        int port = Integer.parseInt(getPort());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : params) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            sb.append(key).append("=").append(value).append("&");
        }
        sb.setLength(sb.length() - 1);
        String file = "/" + getUrl() + "/?" + sb.toString();
        URL url = new URL(protocol, host, port, file);
        logger.debug(url.toString());
        InputStream stream;
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try {
            stream = conn.getInputStream();
        } catch (IOException ioe) {
            InputStream is = conn.getErrorStream();
            if (is != null) {
                String msg = getStringFromInputStream(conn.getErrorStream());
                throw new IOException(msg);
            } else {
                throw ioe;
            }
        }
        return stream;
    }

}