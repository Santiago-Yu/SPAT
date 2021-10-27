class n20514304 {
	@SuppressWarnings("unchecked")
	private Map<String, Object> _request(String Zkv6O0hR, String z4V9zsY9, Map<String, Object> CDIKfciA,
			JSONRecognizer... IQraguww) throws IOException, TwinException {
		String HwoFENpM = url + z4V9zsY9;
		HttpRequest uw8TsRF4;
		if (CDIKfciA == null) {
			BasicHttpRequest yeYDfAc3 = new BasicHttpRequest(Zkv6O0hR, HwoFENpM);
			uw8TsRF4 = yeYDfAc3;
		} else {
			BasicHttpEntityEnclosingRequest ePDGG5Yy = new BasicHttpEntityEnclosingRequest(Zkv6O0hR, HwoFENpM);
			StringEntity ZRa7R7hO;
			try {
				ZRa7R7hO = new StringEntity(JSON.encode(CDIKfciA), "utf-8");
			} catch (UnsupportedEncodingException EZ3ljMfX) {
				throw new RuntimeException(EZ3ljMfX);
			}
			ZRa7R7hO.setContentType("application/json; charset=utf-8");
			ePDGG5Yy.setEntity(ZRa7R7hO);
			uw8TsRF4 = ePDGG5Yy;
		}
		HttpClient nzCCE3lV = getClient();
		try {
			HttpResponse EmxftfNm = nzCCE3lV.execute(new HttpHost(url.getHost(), url.getPort()), uw8TsRF4);
			HttpEntity Xszez4UQ = EmxftfNm.getEntity();
			if (Xszez4UQ == null)
				return null;
			String jmjFjEL2 = Xszez4UQ.getContentType().getValue();
			boolean P8GBSKqT = (jmjFjEL2 != null)
					&& ("application/json".equals(jmjFjEL2) || jmjFjEL2.startsWith("application/json;"));
			String IJqryozb = null;
			InputStream rbInPhDF = Xszez4UQ.getContent();
			try {
				Reader F8L3HubW = new InputStreamReader(rbInPhDF, "UTF-8");
				StringBuilder glRS1anY = new StringBuilder();
				char[] Coo4FYxv = new char[256];
				int gQ03yY5I;
				while ((gQ03yY5I = F8L3HubW.read(Coo4FYxv, 0, Coo4FYxv.length)) >= 0)
					glRS1anY.append(Coo4FYxv, 0, gQ03yY5I);
				F8L3HubW.close();
				IJqryozb = glRS1anY.toString();
			} finally {
				try {
					rbInPhDF.close();
				} catch (Exception G1mS5u0k) {
				}
			}
			int SCwKDmMl = EmxftfNm.getStatusLine().getStatusCode();
			if (SCwKDmMl >= 400) {
				if (P8GBSKqT) {
					try {
						throw deserializeException((Map<String, Object>) JSON.decode(IJqryozb));
					} catch (IllegalArgumentException iM1P5zfB) {
						throw TwinError.UnknownError.create("Couldn't parse error response: \n" + IJqryozb, iM1P5zfB);
					}
				}
				if (SCwKDmMl == 404)
					throw TwinError.UnknownCommand
							.create("Got server response " + SCwKDmMl + " for request " + HwoFENpM);
				else
					throw TwinError.UnknownError.create(
							"Got server response " + SCwKDmMl + " for request " + HwoFENpM + "\nBody is " + IJqryozb);
			}
			if (!P8GBSKqT)
				throw TwinError.UnknownError.create(
						"Got wrong content type " + jmjFjEL2 + " for request " + HwoFENpM + "\nBody is " + IJqryozb);
			try {
				return (Map<String, Object>) JSON.decode(IJqryozb, IQraguww);
			} catch (Exception yjLXqxrN) {
				throw TwinError.UnknownError
						.create("Malformed JSON result for request " + HwoFENpM + ": \nBody is " + IJqryozb, yjLXqxrN);
			}
		} catch (ClientProtocolException RkJ8yMMm) {
			throw new IOException(RkJ8yMMm);
		}
	}

}