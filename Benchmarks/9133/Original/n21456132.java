class n21456132{
    @TestTargetNew(level = TestLevel.COMPLETE, notes = "", method = "getLocalCertificates", args = {  })
    public final void test_getLocalCertificates() {
        try {
            URL url = new URL("https://localhost:55555");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            try {
                connection.getLocalCertificates();
                fail("IllegalStateException wasn't thrown");
            } catch (IllegalStateException ise) {
            }
        } catch (Exception e) {
            fail("Unexpected exception " + e + " for exception case");
        }
        try {
            HttpsURLConnection con = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.508");
            assertNull(con.getLocalCertificates());
            con = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.509");
            Certificate[] cert = con.getLocalCertificates();
            assertNotNull(cert);
            assertEquals(1, cert.length);
        } catch (Exception e) {
            fail("Unexpected exception " + e);
        }
    }

}