class n21456136{
    @TestTargetNew(level = TestLevel.COMPLETE, notes = "", method = "getLocalPrincipal", args = {  })
    public final void test_getLocalPrincipal() {
        try {
            URL url = new URL("https://localhost:55555");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            try {
                connection.getLocalPrincipal();
                fail("IllegalStateException wasn't thrown");
            } catch (IllegalStateException ise) {
            }
        } catch (Exception e) {
            fail("Unexpected exception " + e + " for exception case");
        }
        try {
            HttpsURLConnection con = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.508");
            assertNull(con.getLocalPrincipal());
            con = new MyHttpsURLConnection(new URL("https://www.fortify.net/"), "X.509");
            assertNotNull("Local principal is null", con.getLocalPrincipal());
        } catch (Exception e) {
            fail("Unexpected exception " + e);
        }
    }

}