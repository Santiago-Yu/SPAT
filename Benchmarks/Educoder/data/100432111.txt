    public void testHttpsConnection() throws Throwable {
        setUpStoreProperties();
        try {
            SSLContext ctx = getContext();
            ServerSocket ss = ctx.getServerSocketFactory().createServerSocket(0);
            TestHostnameVerifier hnv = new TestHostnameVerifier();
            HttpsURLConnection.setDefaultHostnameVerifier(hnv);
            URL url = new URL("https://localhost:" + ss.getLocalPort());
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            SSLSocket peerSocket = (SSLSocket) doInteraction(connection, ss);
            checkConnectionStateParameters(connection, peerSocket);
            connection.connect();
        } finally {
            tearDownStoreProperties();
        }
    }
