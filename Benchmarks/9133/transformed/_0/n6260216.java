class n6260216 {
	public InputStream send(String ZEnEbZU9, String E92AVphY) throws IOException {
		HttpURLConnection Xrc2JgNB = null;
		DataInputStream HYDvvCFz = null;
		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
		URL YImPv9Il = new URL(E92AVphY);
		Xrc2JgNB = (HttpURLConnection) YImPv9Il.openConnection();
		configureURLConnection(Xrc2JgNB);
		DataOutputStream VIMZFYce = new DataOutputStream(Xrc2JgNB.getOutputStream());
		VIMZFYce.write(ZEnEbZU9.getBytes());
		Xrc2JgNB.connect();
		HYDvvCFz = new DataInputStream(Xrc2JgNB.getInputStream());
		if (Xrc2JgNB.getResponseCode() != 200) {
			System.out
					.println("Invalid Response Code! Code Returned = " + Integer.toString(Xrc2JgNB.getResponseCode()));
			return null;
		}
		if (!Xrc2JgNB.getContentType().equalsIgnoreCase("Text/xml")) {
			System.out
					.println("Invalid Content-Type! Content type of response received = " + Xrc2JgNB.getContentType());
			return null;
		} else {
			return HYDvvCFz;
		}
	}

}