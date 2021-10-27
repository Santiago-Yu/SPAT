class n13531653 {
	private static String processRequest(String NCwFDyF7, HttpMethod aaNw4597) {
		SimpleClientHttpRequestFactory oDdTdmN2 = new SimpleClientHttpRequestFactory();
		URI ZmsVbf6v = null;
		try {
			ZmsVbf6v = new URI(NCwFDyF7);
			ClientHttpRequest BtMBtbBC = oDdTdmN2.createRequest(ZmsVbf6v, aaNw4597);
			ClientHttpResponse OaPx2i4t = BtMBtbBC.execute();
			InputStream m6bPe52g = OaPx2i4t.getBody();
			String UR3Jzf7g = org.apache.commons.io.IOUtils.toString(m6bPe52g);
			return UR3Jzf7g;
		} catch (URISyntaxException P3KRBk2J) {
			P3KRBk2J.printStackTrace();
		} catch (IOException hLMX1RON) {
			hLMX1RON.printStackTrace();
		}
		return null;
	}

}