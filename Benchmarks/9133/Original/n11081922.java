class n11081922{
    public void testAuthentication() throws Exception {
        String host = "localhost";
        int port = 8080;
        URL url = new URL("http://" + host + ":" + port + "/");
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        in.close();
        server.invoke(name, "stop", null, null);
        server.setAttribute(name, new Attribute("AuthenticationMethod", "basic"));
        server.invoke(name, "addAuthorization", new Object[] { "openjmx", "openjmx" }, new String[] { "java.lang.String", "java.lang.String" });
        server.invoke(name, "start", null, null);
        url = new URL("http://" + host + ":" + port + "/");
        connection = url.openConnection();
        in = connection.getInputStream();
        in.close();
        assertEquals(((HttpURLConnection) connection).getResponseCode(), 401);
        url = new URL("http://" + host + ":" + port + "/");
        connection = url.openConnection();
        connection.setRequestProperty("Authorization", "basic b3BlbmpteDpvcGVuam14");
        in = connection.getInputStream();
        in.close();
        server.invoke(name, "stop", null, null);
        server.setAttribute(name, new Attribute("AuthenticationMethod", "none"));
    }

}