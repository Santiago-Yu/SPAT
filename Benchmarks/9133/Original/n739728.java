class n739728{
    private static String saveCookie(String username, String password) {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }
        } };
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            URL url = new URL("https://ssl.rapidshare.com/cgi-bin/premiumzone.cgi");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write("login=" + username + "&password=" + password);
            out.flush();
            String cookie = conn.getHeaderField("Set-Cookie");
            cookie = cookie.substring(0, cookie.indexOf(";"));
            out.close();
            conn.disconnect();
            return cookie;
        } catch (Exception e) {
            return "";
        }
    }

}