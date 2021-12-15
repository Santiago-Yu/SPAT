class n20425886 {
	@TestTargetNew(level = TestLevel.PARTIAL_COMPLETE, notes = "Tests Proxy functionality. Indirect test.", method = "Proxy", args = {
			java.net.Proxy.Type.class, java.net.SocketAddress.class })
	@BrokenTest("the host address isn't working anymore")
	public void test_openConnectionLjava_net_Proxy() throws IOException {
		SocketAddress addr1 = new InetSocketAddress(Support_Configuration.ProxyServerTestHost, 808);
		SocketAddress addr2 = new InetSocketAddress(Support_Configuration.ProxyServerTestHost, 1080);
		Proxy proxy1 = new Proxy(Proxy.Type.HTTP, addr1);
		Proxy proxy2 = new Proxy(Proxy.Type.SOCKS, addr2);
		Proxy proxyList[] = { proxy1, proxy2 };
		for (int i = 0; i < proxyList.length; ++i) {
			String posted = "just a test";
			URL u = new URL("http://" + Support_Configuration.ProxyServerTestHost + "/cgi-bin/test.pl");
			java.net.HttpURLConnection conn = (java.net.HttpURLConnection) u.openConnection(proxyList[i]);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-length", String.valueOf(posted.length()));
			OutputStream out = conn.getOutputStream();
			out.write(posted.getBytes());
			out.close();
			conn.getResponseCode();
			InputStream is = conn.getInputStream();
			String response = "";
			byte[] b = new byte[1024];
			int count = 0;
			while ((count = is.read(b)) > 0) {
				response += new String(b, 0, count);
			}
			assertTrue("Response to POST method invalid", (posted != null && posted.equals(response)));
		}
		URL httpUrl = new URL("http://abc.com");
		URL jarUrl = new URL("jar:" + Support_Resources.getResourceURL("/JUC/lf.jar!/plus.bmp"));
		URL ftpUrl = new URL("ftp://" + Support_Configuration.FTPTestAddress + "/nettest.txt");
		URL fileUrl = new URL("file://abc");
		URL[] urlList = { httpUrl, jarUrl, ftpUrl, fileUrl };
		for (int i = 0; i < urlList.length; ++i) {
			try {
				urlList[i].openConnection(null);
			} catch (IllegalArgumentException iae) {
			}
		}
		fileUrl.openConnection(Proxy.NO_PROXY);
	}

}