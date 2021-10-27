class n19136768{
    public static void main(String[] args) {
        CookieManager cm = new CookieManager();
        try {
            URL url = new URL("http://www.hccp.org/test/cookieTest.jsp");
            URLConnection conn = url.openConnection();
            conn.connect();
            cm.storeCookies(conn);
            System.out.println(cm);
            cm.setCookies(url.openConnection());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}