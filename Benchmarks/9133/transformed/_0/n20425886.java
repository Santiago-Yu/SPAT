class n20425886 {
	@TestTargetNew(level = TestLevel.PARTIAL_COMPLETE, notes = "Tests Proxy functionality. Indirect test.", method = "Proxy", args = {
			java.net.Proxy.Type.class, java.net.SocketAddress.class })
	@BrokenTest("the host address isn't working anymore")
	public void test_openConnectionLjava_net_Proxy() throws IOException {
		SocketAddress o5QQL7q4 = new InetSocketAddress(Support_Configuration.ProxyServerTestHost, 808);
		SocketAddress Kytp4fVk = new InetSocketAddress(Support_Configuration.ProxyServerTestHost, 1080);
		Proxy G086lMUV = new Proxy(Proxy.Type.HTTP, o5QQL7q4);
		Proxy lPbH7LoK = new Proxy(Proxy.Type.SOCKS, Kytp4fVk);
		Proxy alpdFgAr[] = { G086lMUV, lPbH7LoK };
		for (int gXoQPi80 = 0; gXoQPi80 < alpdFgAr.length; ++gXoQPi80) {
			String SRMp34du = "just a test";
			URL rX9EBUqK = new URL("http://" + Support_Configuration.ProxyServerTestHost + "/cgi-bin/test.pl");
			java.net.HttpURLConnection qpsIq6jZ = (java.net.HttpURLConnection) rX9EBUqK
					.openConnection(alpdFgAr[gXoQPi80]);
			qpsIq6jZ.setDoOutput(true);
			qpsIq6jZ.setRequestMethod("POST");
			qpsIq6jZ.setRequestProperty("Content-length", String.valueOf(SRMp34du.length()));
			OutputStream UJ5eG4rh = qpsIq6jZ.getOutputStream();
			UJ5eG4rh.write(SRMp34du.getBytes());
			UJ5eG4rh.close();
			qpsIq6jZ.getResponseCode();
			InputStream KfH2h94S = qpsIq6jZ.getInputStream();
			String rIsiAsQE = "";
			byte[] PSB9AyMj = new byte[1024];
			int ItI6RxvD = 0;
			while ((ItI6RxvD = KfH2h94S.read(PSB9AyMj)) > 0) {
				rIsiAsQE += new String(PSB9AyMj, 0, ItI6RxvD);
			}
			assertTrue("Response to POST method invalid", rIsiAsQE.equals(SRMp34du));
		}
		URL LG9Cd3Dr = new URL("http://abc.com");
		URL NiRTRwh7 = new URL("jar:" + Support_Resources.getResourceURL("/JUC/lf.jar!/plus.bmp"));
		URL StmljFCD = new URL("ftp://" + Support_Configuration.FTPTestAddress + "/nettest.txt");
		URL bnAYd4g0 = new URL("file://abc");
		URL[] xRqGXfKN = { LG9Cd3Dr, NiRTRwh7, StmljFCD, bnAYd4g0 };
		for (int I4t8toBe = 0; I4t8toBe < xRqGXfKN.length; ++I4t8toBe) {
			try {
				xRqGXfKN[I4t8toBe].openConnection(null);
			} catch (IllegalArgumentException Nu9YQRA8) {
			}
		}
		bnAYd4g0.openConnection(Proxy.NO_PROXY);
	}

}