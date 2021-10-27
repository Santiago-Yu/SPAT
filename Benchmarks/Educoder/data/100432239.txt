    private static void doGet(LNISoapServlet lni, String itemHandle, String packager, String output, String endpoint) throws java.rmi.RemoteException, ProtocolException, IOException, FileNotFoundException {
        String itemURI = doLookup(lni, itemHandle, null);
        URL url = LNIClientUtils.makeDAVURL(endpoint, itemURI, packager);
        System.err.println("DEBUG: GET from URL: " + url.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        fixBasicAuth(url, conn);
        conn.connect();
        int status = conn.getResponseCode();
        if (status < 200 || status >= 300) {
            die(status, "HTTP error, status=" + String.valueOf(status) + ", message=" + conn.getResponseMessage());
        }
        InputStream in = conn.getInputStream();
        OutputStream out = new FileOutputStream(output);
        copyStream(in, out);
        in.close();
        out.close();
        System.err.println("DEBUG: Created local file " + output);
        System.err.println("RESULT: Status=" + String.valueOf(conn.getResponseCode()) + " " + conn.getResponseMessage());
    }
