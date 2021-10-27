class n11312019{
    public static String sendGetRequest(String endpoint, String requestParameters) {
        String result = null;
        if (endpoint.startsWith("http://")) {
            try {
                System.setProperty("java.net.useSystemProxies", "true");
                String urlStr = endpoint;
                if (requestParameters != null && requestParameters.length() > 0) {
                    urlStr += "?" + requestParameters;
                }
                URL url = new URL(urlStr);
                URLConnection conn = url.openConnection();
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = rd.readLine()) != null) {
                    sb.append(line + "\n");
                }
                rd.close();
                result = sb.toString();
            } catch (Exception e) {
                DebuggerQueue.addDebug(HTTPClient.class.getName(), Level.ERROR, "Error during download url %s error: %s", endpoint, e.getMessage());
            }
        }
        return result;
    }

}