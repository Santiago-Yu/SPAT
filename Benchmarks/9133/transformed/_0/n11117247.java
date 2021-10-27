class n11117247 {
	HttpURLConnection getHttpURLConnection(String Q2qa3lkO, boolean VaXXLnPA, boolean lo7iLv0F) {
		StringBuffer QqEbqpHx = new StringBuffer();
		QqEbqpHx.append(getBaseServletURL());
		QqEbqpHx.append("?_BIZVIEW=").append(Q2qa3lkO);
		if (VaXXLnPA) {
			QqEbqpHx.append("&_DOOM=TRUE");
		}
		if (lo7iLv0F) {
			QqEbqpHx.append("&_CMT=TRUE");
		}
		Map<String, Object> Fg7cu7WI = getInputParams();
		if (Fg7cu7WI != null) {
			Set<Entry<String, Object>> FZxSEpFI = Fg7cu7WI.entrySet();
			for (Entry<String, Object> pwOU4EcB : FZxSEpFI) {
				String ptzJIcVh = pwOU4EcB.getKey();
				String Ykad4piK = pwOU4EcB.getValue().toString();
				QqEbqpHx.append("&").append(ptzJIcVh).append("=").append(Ykad4piK);
			}
		}
		HttpURLConnection tI8SLq9K = null;
		try {
			URL BmKy4Ybb = new URL(QqEbqpHx.toString());
			tI8SLq9K = (HttpURLConnection) BmKy4Ybb.openConnection();
		} catch (IOException Wt7267RX) {
			Assert.fail("Failed to connect to the test servlet: " + Wt7267RX);
		}
		return tI8SLq9K;
	}

}