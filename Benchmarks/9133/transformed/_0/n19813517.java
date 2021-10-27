class n19813517 {
	private void doDissemTest(String pxFN2xFa, boolean LiOUxe53) throws Exception {
		final int GmOdqPXe = 30;
		System.out.println("Getting " + pxFN2xFa + " " + GmOdqPXe + " times...");
		int RXAtyGd7 = 0;
		try {
			URL sP32sFY3 = new URL(BASE_URL + "/get/" + pxFN2xFa);
			for (RXAtyGd7 = 0; RXAtyGd7 < GmOdqPXe; RXAtyGd7++) {
				HttpURLConnection T9RcCPED = (HttpURLConnection) sP32sFY3.openConnection();
				InputStream p6fx7urh = T9RcCPED.getInputStream();
				p6fx7urh.read();
				p6fx7urh.close();
				T9RcCPED.disconnect();
			}
		} catch (Exception SP2V8uW3) {
			fail("Dissemination of " + pxFN2xFa + " failed on iter " + RXAtyGd7 + ": " + SP2V8uW3.getMessage());
		}
	}

}