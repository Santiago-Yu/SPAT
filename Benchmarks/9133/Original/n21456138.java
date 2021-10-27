class n21456138{
    @TestTargetNew(level = TestLevel.COMPLETE, notes = "", method = "getServerCertificates", args = {  })
    public final void test_getServerCertificates() throws Exception {
        try {
            URL url = new URL("https://localhost:55555");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            try {
                connection.getServerCertificates();
                fail("IllegalStateException wasn't thrown");
            } catch (IllegalStateException ise) {
            }
        } catch (Exception e) {
            fail("Unexpected exception " + e + " for exception case");
        }
        HttpsURLConnection con = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.508");
        try {
            Certificate[] cert = con.getServerCertificates();
            fail("SSLPeerUnverifiedException wasn't thrown");
        } catch (SSLPeerUnverifiedException e) {
        }
        con = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.509");
        try {
            Certificate[] cert = con.getServerCertificates();
            assertNotNull(cert);
            assertEquals(1, cert.length);
        } catch (Exception e) {
            fail("Unexpected exception " + e);
        }
    }

}