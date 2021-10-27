class n17407851 {
	private String _doPost(final String yBvpftCY, final Map<String, String> k9rCyUyM) {
		String HIKYh6BV = "";
		for (String gELIQYhR : k9rCyUyM.keySet()) {
			try {
				HIKYh6BV += URLEncoder.encode(gELIQYhR, ENCODING) + "="
						+ URLEncoder.encode(k9rCyUyM.get(gELIQYhR), ENCODING) + "&";
			} catch (UnsupportedEncodingException ucv9x8li) {
				s_logger.debug("UnsupportedEncodingException caught. Trying to encode: " + gELIQYhR + " and "
						+ k9rCyUyM.get(gELIQYhR));
				return null;
			}
		}
		if (HIKYh6BV.length() == 0) {
			s_logger.debug("POST will not complete, no parameters specified.");
			return null;
		}
		s_logger.debug("POST to server will be done with the following parameters: " + HIKYh6BV);
		HttpURLConnection dcMVKvas = null;
		String QobL6LaN = null;
		try {
			dcMVKvas = (HttpURLConnection) (new URL(yBvpftCY)).openConnection();
			dcMVKvas.setRequestMethod(REQUEST_METHOD);
			dcMVKvas.setDoOutput(true);
			DataOutputStream IBZIfl6X = new DataOutputStream(dcMVKvas.getOutputStream());
			IBZIfl6X.write(HIKYh6BV.getBytes());
			IBZIfl6X.flush();
			IBZIfl6X.close();
			InputStream E467DxCn = dcMVKvas.getInputStream();
			BufferedReader qLOYh4br = new BufferedReader(new InputStreamReader(E467DxCn));
			String XdnVgZri;
			StringBuffer xFwwMA3k = new StringBuffer();
			while ((XdnVgZri = qLOYh4br.readLine()) != null) {
				xFwwMA3k.append(XdnVgZri);
				xFwwMA3k.append('\r');
			}
			qLOYh4br.close();
			QobL6LaN = xFwwMA3k.toString();
		} catch (ProtocolException b0pGTSmI) {
			s_logger.debug("ProtocolException caught. Unable to execute POST.");
		} catch (MalformedURLException rOhTspVJ) {
			s_logger.debug("MalformedURLException caught. Unexpected. Url is: " + yBvpftCY);
		} catch (IOException bKL1Vm8o) {
			s_logger.debug("IOException caught. Unable to execute POST.");
		}
		return QobL6LaN;
	}

}