class n6930078{
    public void ztest_cluster() throws Exception {
        Configuration.init();
        TomcatServer ts1 = new TomcatServer();
        ts1.registerServlet("/*", TestServlet.class.getName());
        ts1.registerCluster(5554);
        ts1.start(5555);
        TomcatServer ts2 = new TomcatServer();
        ts2.registerServlet("/*", TestServlet.class.getName());
        ts2.registerCluster(5554);
        ts2.start(5556);
        URL url1 = new URL("http://127.0.0.1:5555/a");
        HttpURLConnection c1 = (HttpURLConnection) url1.openConnection();
        assert getData(c1).equals("a null");
        String cookie = c1.getHeaderField("Set-Cookie");
        Thread.sleep(5000);
        URL url2 = new URL("http://127.0.0.1:5556/a");
        HttpURLConnection c2 = (HttpURLConnection) url2.openConnection();
        c2.setRequestProperty("Cookie", cookie);
        assert getData(c2).equals("a a");
    }

}