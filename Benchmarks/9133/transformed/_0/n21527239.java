class n21527239 {
	private final Node openConnection(String fILESGge) throws JTweetException {
		try {
			URL rJY4Hgb5 = new URL(fILESGge);
			HttpURLConnection ry6P3zX0 = (HttpURLConnection) rJY4Hgb5.openConnection();
			ry6P3zX0.connect();
			BufferedInputStream xgpFNfkP = new BufferedInputStream(ry6P3zX0.getInputStream());
			if (builder == null) {
				builder = factory.newDocumentBuilder();
			}
			document = builder.parse(xgpFNfkP);
			xgpFNfkP.close();
			ry6P3zX0.disconnect();
		} catch (Exception D550KaRP) {
			throw new JTweetException(D550KaRP);
		}
		return document.getFirstChild();
	}

}