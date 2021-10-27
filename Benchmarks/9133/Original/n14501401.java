class n14501401{
    private void checkServerAccess() throws IOException {
        URL url = new URL("https://testnetbeans.org/bugzilla/index.cgi");
        try {
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.connect();
        } catch (IOException exc) {
            disableMessage = "Bugzilla is not accessible";
        }
        url = new URL(BugzillaConnector.SERVER_URL);
        try {
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.connect();
        } catch (IOException exc) {
            disableMessage = "Bugzilla Service is not accessible";
        }
    }

}