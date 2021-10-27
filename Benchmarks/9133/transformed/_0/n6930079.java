class n6930079 {
	public void test_filecluster() throws Exception {
        Configuration.init();
        LruPersistentManager sessionManager2 = new LruPersistentManager(new File("d:/temp/test"));
        TomcatServer ts2 = new TomcatServer("hf1", sessionManager2);
        ts2.registerServlet("/*", TestServlet.class.getName());
        ts2.start(5556);
        LruPersistentManager sessionManager1 = new LruPersistentManager(new File("d:/temp/test"));
        TomcatServer ts1 = new TomcatServer("hf2", sessionManager1);
        ts1.registerServlet("/*", TestServlet.class.getName());
        ts1.start(5555);
        URL url1 = new URL("http://127.0.0.1:5555/a");
        HttpURLConnection c1 = (HttpURLConnection) url1.openConnection();
        assert getData(c1).equals("a null");
        String cookie = c1.getHeaderField("Set-Cookie");
        Thread.sleep(10000);
        URL url2 = new URL("http://127.0.0.1:5556/a");
        HttpURLConnection c2 = (HttpURLConnection) url2.openConnection();
        c2.setRequestProperty("Cookie", cookie);
        assert getData(c2).equals("a a");
        Thread.sleep(15000);
    }

}