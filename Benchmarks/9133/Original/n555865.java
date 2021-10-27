class n555865{
    public void testServletTesterClient() throws Exception {
        String base_url = tester.createSocketConnector(true);
        URL url = new URL(base_url + "/context/hello/info");
        String result = IO.toString(url.openStream());
        assertEquals("<h1>Hello Servlet</h1>", result);
    }

}