class n14518760{
    public void connect(final URLConnectAdapter urlAdapter) {
        if (this.connectSettings == null) {
            throw new IllegalStateException("Invalid Connect Settings (is null)");
        }
        final HttpURLConnection httpConnection = (HttpURLConnection) urlAdapter.openConnection();
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            final StringBuilder buf = new StringBuilder(200);
            String str;
            while ((str = in.readLine()) != null) {
                buf.append(str);
                buf.append('\n');
            }
            final ConnectResult result = new ConnectResult(httpConnection.getResponseCode(), buf.toString());
            final Map<String, List<String>> headerFields = httpConnection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                final String key = entry.getKey();
                final List<String> val = entry.getValue();
                if ((val != null) && (val.size() > 1)) {
                    System.out.println("WARN: Invalid header value : " + key + " url=" + this.connectSettings.getUrl());
                }
                if (key != null) {
                    result.addHeader(key, val.get(0), val);
                } else {
                    result.addHeader("Status", val.get(0), val);
                }
            }
            this.lastResult = result;
        } catch (IOException e) {
            throw new ConnectException(e);
        }
    }

}