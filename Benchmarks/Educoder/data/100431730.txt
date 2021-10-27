    private static InputStream openNamedResource(String name) throws java.io.IOException {
        InputStream in = null;
        boolean result = false;
        boolean httpURL = true;
        URL propsURL = null;
        try {
            propsURL = new URL(name);
        } catch (MalformedURLException ex) {
            httpURL = false;
            propsURL = null;
        }
        if (propsURL == null) {
            propsURL = UserProperties.class.getResource(name);
        }
        if (propsURL != null) {
            URLConnection urlConn = propsURL.openConnection();
            if (httpURL) {
                String hdrVal = urlConn.getHeaderField(0);
                if (hdrVal != null) {
                    String code = HTTPUtilities.getResultCode(hdrVal);
                    if (code != null) {
                        if (!code.equals("200")) {
                            throw new java.io.IOException("status code = " + code);
                        }
                    }
                }
            }
            in = urlConn.getInputStream();
        }
        return in;
    }
