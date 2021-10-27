class n5274228 {
	public String put(String dgzfZ7Ws, Map<String, String> JfqNCBoV) {
		HttpClient wsvDdA5s = new DefaultHttpClient();
		wsvDdA5s.getParams().setParameter("http.useragent", "sla@soi OCCI Client v0.2");
		HttpPut cyN13IPQ = new HttpPut(dgzfZ7Ws);
		List<Header> ShAE9Bio = this.convert2Headers(JfqNCBoV);
		for (Iterator<Header> zXpd8Sey = ShAE9Bio.iterator(); zXpd8Sey.hasNext();) {
			cyN13IPQ.addHeader(zXpd8Sey.next());
		}
		logger.info(cyN13IPQ.getRequestLine());
		logger.info(cyN13IPQ.getAllHeaders());
		Header[] eTisTJ6s = cyN13IPQ.getAllHeaders();
		String[] OflABVvA = { Response.Location };
		HashMap<String, String> vUZzQUc9 = new HashMap<String, String>();
		for (int FwXqT1Rw = 0; FwXqT1Rw < eTisTJ6s.length; FwXqT1Rw++) {
			Header CnF1kdmz = eTisTJ6s[FwXqT1Rw];
			logger.info("header - request  -" + CnF1kdmz.toString());
			logger.info("	headerName - " + CnF1kdmz.getName());
			logger.info("	headerValue - " + CnF1kdmz.getValue());
		}
		String xcKIiqB6 = null;
		try {
			HttpResponse lBeFf4Ra = wsvDdA5s.execute(cyN13IPQ);
			xcKIiqB6 = lBeFf4Ra.getStatusLine().toString();
			int RhhXzLuV = lBeFf4Ra.getStatusLine().getStatusCode();
			logger.info("----------------------------------------");
			logger.info("StatusLine - (full) - " + lBeFf4Ra.getStatusLine());
			logger.info("	StatusCode - " + RhhXzLuV);
			logger.info("	Reason - " + lBeFf4Ra.getStatusLine().getReasonPhrase());
			logger.info("	Protocol - " + lBeFf4Ra.getStatusLine().getProtocolVersion().toString());
			logger.info("----------------------------------------");
			if (StatusCode.validate(RhhXzLuV)) {
				logger.info("Response Validated");
			} else {
				logger.error("Response NOT Validated");
				return null;
			}
			Header[] DGGbeQam = lBeFf4Ra.getAllHeaders();
			for (int MWYxn6OI = 0; MWYxn6OI < DGGbeQam.length; MWYxn6OI++) {
				Header YvmTvKav = DGGbeQam[MWYxn6OI];
				logger.info("header - response - " + YvmTvKav.toString());
				logger.info("	headerName - " + YvmTvKav.getName());
				logger.info("	headerValue - " + YvmTvKav.getValue());
				for (int v5NQt6Dh = 0; v5NQt6Dh < OflABVvA.length; v5NQt6Dh++) {
					logger.info("	Looking for  - " + OflABVvA[v5NQt6Dh]);
					if (OflABVvA[v5NQt6Dh].equals(YvmTvKav.getName().toString())) {
						logger.info("	Found an OCCI Header - " + YvmTvKav.getName());
						vUZzQUc9.put(YvmTvKav.getName(), YvmTvKav.getValue());
					}
				}
			}
		} catch (org.apache.http.conn.HttpHostConnectException JwWZddjE) {
			JwWZddjE.printStackTrace();
			logger.error(JwWZddjE);
			return null;
		} catch (ClientProtocolException oKqImvnT) {
			oKqImvnT.printStackTrace();
			logger.error(oKqImvnT);
			return null;
		} catch (IOException FFgKaIg4) {
			FFgKaIg4.printStackTrace();
			logger.error(FFgKaIg4);
			return null;
		} finally {
			wsvDdA5s.getConnectionManager().shutdown();
		}
		logger.info("occiHeaders - " + vUZzQUc9);
		if (vUZzQUc9.containsKey(Response.Location)) {
			logger.info("Valid Provision" + xcKIiqB6);
			return vUZzQUc9.get(Response.Location).toString().replaceAll(Response.jobs, "");
		}
		logger.info("NOT a Valid Provision - " + xcKIiqB6);
		return xcKIiqB6;
	}

}