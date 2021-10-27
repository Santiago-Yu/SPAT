class n6541771 {
	private String sendMail() throws IOException {
		String WOK2jetw = StringEscapeUtils.escapeHtml(message.getText());
		StringBuffer sPtoEI5Z = new StringBuffer();
		sPtoEI5Z.append(encode("n", name.getText()));
		sPtoEI5Z.append("&").append(encode("e", email.getText()));
		sPtoEI5Z.append("&").append(encode("r", recpt.getText()));
		sPtoEI5Z.append("&").append(encode("m", WOK2jetw));
		sPtoEI5Z.append("&").append(encode("s", score));
		sPtoEI5Z.append("&").append(encode("i", calcScoreImage()));
		sPtoEI5Z.append("&").append(encode("c", digest(recpt.getText() + "_" + score)));
		URL cOjBADQU = new URL("http://www.enerjy.com/share/mailit.php");
		URLConnection mjTsHXiP = cOjBADQU.openConnection();
		mjTsHXiP.setDoOutput(true);
		OutputStreamWriter G7jaQMlU = null;
		BufferedReader wA4KkWXO = null;
		boolean qjpUk611 = false;
		try {
			G7jaQMlU = new OutputStreamWriter(mjTsHXiP.getOutputStream());
			G7jaQMlU.write(sPtoEI5Z.toString());
			G7jaQMlU.flush();
			wA4KkWXO = new BufferedReader(new InputStreamReader(mjTsHXiP.getInputStream()));
			for (String BqWFmQAf = wA4KkWXO.readLine(); null != BqWFmQAf; BqWFmQAf = wA4KkWXO.readLine()) {
				if (BqWFmQAf.startsWith("err:")) {
					return BqWFmQAf.substring(4);
				} else if (BqWFmQAf.equals("ok")) {
					qjpUk611 = true;
				}
			}
		} finally {
			StreamUtils.close(G7jaQMlU);
			StreamUtils.close(wA4KkWXO);
		}
		if (!qjpUk611) {
			return "The server did not return a response.";
		}
		return null;
	}

}