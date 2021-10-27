class n17363729 {
	private String sendImpl(String s4VeqXvb, String ab4dU57h, String GLj0nrmk) throws IOException {
		final QueryStringBuilder fYu2Zo07 = new QueryStringBuilder();
		fYu2Zo07.append("user", username);
		fYu2Zo07.append("password", password);
		fYu2Zo07.append("api_id", apiId);
		fYu2Zo07.append("to", ab4dU57h);
		if (s4VeqXvb != null) {
			fYu2Zo07.append("from", s4VeqXvb);
		}
		fYu2Zo07.append("text", GLj0nrmk);
		final URL aOCu90xt = new URL(CLICKATELL_GATEWAY_URL + "sendmsg" + fYu2Zo07.toString());
		final HttpURLConnection dMSAfetT = (HttpURLConnection) aOCu90xt.openConnection();
		dMSAfetT.connect();
		final BufferedReader arU95oac = new BufferedReader(new InputStreamReader(dMSAfetT.getInputStream(), "UTF-8"));
		try {
			return arU95oac.readLine();
		} finally {
			arU95oac.close();
		}
	}

}