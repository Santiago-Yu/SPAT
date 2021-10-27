class n1307907{
    public void testHttpsConnection() {
        try {
            URL url = new URL("https://addons.mozilla.org/zh-CN/firefox/");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.getOutputStream().write("hello".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}