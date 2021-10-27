    public String readURL(String urlLocation, ArrayList headers, RenderEngine c) throws Exception {
        URL url = null;
        HttpURLConnection conn = null;
        InputStream istream = null;
        try {
            url = new URL(urlLocation);
            conn = (HttpURLConnection) url.openConnection();
        } catch (Exception e) {
            throw new Exception("Soap is unable to retrieve URL for '" + urlLocation + "': " + e.getMessage());
        }
        loadCookies(urlLocation, conn, c);
        if (headers != null) {
            for (int i = 0; i < headers.size(); i++) {
                String header = (String) headers.get(i);
                String key = header.substring(0, header.indexOf(":"));
                String value = header.substring(header.indexOf(":") + 2);
                Debug.log("Adding new request header '" + key + "'='" + value + "'");
                conn.setRequestProperty(key, value);
            }
        }
        Debug.debug("Set to use GET, URL=" + urlLocation);
        try {
            istream = conn.getInputStream();
        } catch (Exception e) {
            Debug.debug("Unable to capture input stream: " + e.getMessage());
            throw new Exception("Unable to capture input stream from URL '" + urlLocation + "': " + e.getMessage());
        }
        Debug.debug("'GET' - Got input stream.");
        if (conn.getContentLength() == -1) {
            Debug.debug("Content length = unknown");
        } else {
            Debug.debug("Content length = " + conn.getContentLength());
        }
        byte data[] = null;
        int curPos = 0, contentLength = conn.getContentLength();
        if (conn.getContentLength() == -1) {
            String byteSize = NodeUtil.walkNodeTree(Server.getConfig(), "//configuration/object[@type='engine.tunable']/property[@type='engine.unknowncontentsize']/@value");
            if (byteSize == null) {
                contentLength = 4096;
            } else {
                contentLength = Integer.parseInt(byteSize);
            }
            Debug.debug("Content length unknown.  Allowing fuzz of " + contentLength + " bytes.");
        }
        data = new byte[contentLength];
        try {
            int dataRead = 0;
            while ((dataRead = istream.read(data, curPos, contentLength - curPos)) != -1) {
                if (dataRead == 0) {
                    break;
                }
                curPos += dataRead;
            }
        } catch (Exception e) {
            throw new Exception("Soap is unable to read data from HTTP connection: " + e.getMessage());
        }
        try {
            istream.close();
            conn.disconnect();
        } catch (MalformedURLException e) {
            throw new Exception("Soap request to site '" + urlLocation + "' is invalid: " + e.getMessage());
        } catch (IOException e) {
            throw new Exception("Soap request to site '" + urlLocation + "' failed to connect.");
        }
        String dataOut = new String(data);
        int counter = 0;
        data = null;
        istream = null;
        conn = null;
        url = null;
        return dataOut.trim();
    }
