class n15354002{
    public void testAuthentication() throws Exception {
        String host = "localhost";
        int port = DEFAULT_PORT;
        URL url = new URL("http://" + host + ":" + port + "/");
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        in.close();
        waitToStop();
        server.setAttribute(name, new Attribute("AuthenticationMethod", "basic"));
        server.invoke(name, "addAuthorization", new Object[] { "mx4j", "mx4j" }, new String[] { "java.lang.String", "java.lang.String" });
        server.invoke(name, "start", null, null);
        url = new URL("http://" + host + ":" + port + "/");
        connection = url.openConnection();
        try {
            in = connection.getInputStream();
        } catch (Exception e) {
        } finally {
            in.close();
        }
        assertEquals(((HttpURLConnection) connection).getResponseCode(), 401);
        url = new URL("http://" + host + ":" + port + "/");
        connection = url.openConnection();
        connection.setRequestProperty("Authorization", "basic bXg0ajpteDRq");
        in = connection.getInputStream();
        in.close();
        waitToStop();
        server.setAttribute(name, new Attribute("AuthenticationMethod", "none"));
    }

}