class n5274229 {
	public String post(Map<String, String> vLsaCNw4, String h7rGGpjz) {
		HttpClient aQtxGuXw = new DefaultHttpClient();
		aQtxGuXw.getParams().setParameter("http.useragent", "sla@soi OCCI Client v0.2");
		HttpPost RBA1ShZM = new HttpPost("http://" + hostname + ":" + port + resource);
		List<Header> uvS4iunJ = this.convert2Headers(vLsaCNw4);
		for (Iterator<Header> x2R6alCw = uvS4iunJ.iterator(); x2R6alCw.hasNext();) {
			RBA1ShZM.addHeader(x2R6alCw.next());
		}
		if (h7rGGpjz == null) {
			logger.info("Monitoring Request has not been specified - ");
			h7rGGpjz = Terms.MONITORING_NOT_CONFIGURED;
			logger.info("Monitoring Request has not been specified - " + h7rGGpjz);
		} else {
			logger.info("Monitoring Request is - " + h7rGGpjz);
		}
		logger.info(RBA1ShZM.getRequestLine());
		logger.info(RBA1ShZM.getAllHeaders());
		Header[] v6tUDBpd = RBA1ShZM.getAllHeaders();
		String[] ft9EwFob = { Response.Location };
		HashMap<String, String> cK31ha3n = new HashMap<String, String>();
		for (int axWbyOS1 = 0; axWbyOS1 < v6tUDBpd.length; axWbyOS1++) {
			Header hYXzlRTc = v6tUDBpd[axWbyOS1];
			logger.info("header - request  -" + hYXzlRTc.toString());
			logger.info("	headerName - " + hYXzlRTc.getName());
			logger.info("	headerValue - " + hYXzlRTc.getValue());
		}
		String IVuOqlag = null;
		try {
			HttpResponse q01NjzJT = aQtxGuXw.execute(RBA1ShZM);
			IVuOqlag = q01NjzJT.getStatusLine().toString();
			int KWgEczJj = q01NjzJT.getStatusLine().getStatusCode();
			logger.info("----------------------------------------");
			logger.info("StatusLine - (full) - " + q01NjzJT.getStatusLine());
			logger.info("	StatusCode - " + KWgEczJj);
			logger.info("	Reason - " + q01NjzJT.getStatusLine().getReasonPhrase());
			logger.info("	Protocol - " + q01NjzJT.getStatusLine().getProtocolVersion().toString());
			logger.info("----------------------------------------");
			if (StatusCode.validate(KWgEczJj)) {
				logger.info("Response Validated");
			} else {
				logger.error("Response NOT Validated");
			}
			Header[] S6Ccd8Ve = q01NjzJT.getAllHeaders();
			for (int HZZELJlg = 0; HZZELJlg < S6Ccd8Ve.length; HZZELJlg++) {
				Header LOxukIsz = S6Ccd8Ve[HZZELJlg];
				logger.info("header - response - " + LOxukIsz.toString());
				logger.info("	headerName - " + LOxukIsz.getName());
				logger.info("	headerValue - " + LOxukIsz.getValue());
				for (int y9UsSsn3 = 0; y9UsSsn3 < ft9EwFob.length; y9UsSsn3++) {
					logger.info("	Looking for  - " + ft9EwFob[y9UsSsn3]);
					if (ft9EwFob[y9UsSsn3].equals(LOxukIsz.getName().toString())) {
						logger.info("	Found an OCCI Header - " + LOxukIsz.getName());
						cK31ha3n.put(LOxukIsz.getName(), LOxukIsz.getValue());
					}
				}
			}
		} catch (org.apache.http.conn.HttpHostConnectException S7cFmxQl) {
			S7cFmxQl.printStackTrace();
			logger.error(S7cFmxQl);
			return null;
		} catch (ClientProtocolException sabFG4Iv) {
			sabFG4Iv.printStackTrace();
			logger.error(sabFG4Iv);
			return null;
		} catch (IOException mV2hE248) {
			mV2hE248.printStackTrace();
			logger.error(mV2hE248);
			return null;
		} finally {
			aQtxGuXw.getConnectionManager().shutdown();
		}
		logger.info("occiHeaders - " + cK31ha3n);
		if (cK31ha3n.containsKey(Response.Location)) {
			logger.info("Valid Provision");
			return cK31ha3n.get(Response.Location).toString().replaceAll(Response.jobs, "");
		}
		logger.info("NOT a Valid Provision" + IVuOqlag);
		return null;
	}

}