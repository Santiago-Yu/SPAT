class n22510494 {
	public static void getResponseAsStream(String rIyq16L9, Object axeOFxRy, OutputStream qCzGZGT6,
			Map<String, String> MSjY7CeA, Map<String, String> Yx6wtC4b, String eGxQ0Zrh, int m0Kds6ub)
			throws IOException {
		if (rIyq16L9 == null || rIyq16L9.length() <= 0)
			throw new IllegalArgumentException("Url can not be null.");
		String Bb9VV15Y = rIyq16L9.toLowerCase();
		if (!Bb9VV15Y.startsWith("http://") && !Bb9VV15Y.startsWith("https://"))
			rIyq16L9 = "http://" + rIyq16L9;
		rIyq16L9 = encodeURL(rIyq16L9);
		HttpMethod PFrUFydT = null;
		if (axeOFxRy == null && (Yx6wtC4b == null || Yx6wtC4b.size() <= 0))
			PFrUFydT = new GetMethod(rIyq16L9);
		else
			PFrUFydT = new PostMethod(rIyq16L9);
		HttpMethodParams LuIdf0xL = ((HttpMethodBase) PFrUFydT).getParams();
		if (LuIdf0xL == null) {
			LuIdf0xL = new HttpMethodParams();
			((HttpMethodBase) PFrUFydT).setParams(LuIdf0xL);
		}
		if (m0Kds6ub < 0)
			LuIdf0xL.setSoTimeout(0);
		else
			LuIdf0xL.setSoTimeout(m0Kds6ub);
		if (eGxQ0Zrh != null && eGxQ0Zrh.length() > 0) {
			if (MSjY7CeA == null)
				MSjY7CeA = new HashMap<String, String>();
			MSjY7CeA.put("Content-Type", eGxQ0Zrh);
		}
		if (MSjY7CeA == null || !MSjY7CeA.containsKey("User-Agent")) {
			if (MSjY7CeA == null)
				MSjY7CeA = new HashMap<String, String>();
			MSjY7CeA.put("User-Agent", DEFAULT_USERAGENT);
		}
		if (MSjY7CeA != null) {
			Iterator<Map.Entry<String, String>> iter = MSjY7CeA.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, String> entry = iter.next();
				PFrUFydT.setRequestHeader((String) entry.getKey(), (String) entry.getValue());
			}
		}
		if (PFrUFydT instanceof PostMethod && (Yx6wtC4b != null && Yx6wtC4b.size() > 0)) {
			Iterator<Map.Entry<String, String>> iter = Yx6wtC4b.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<String, String> entry = iter.next();
				((PostMethod) PFrUFydT).addParameter((String) entry.getKey(), (String) entry.getValue());
			}
		}
		if (PFrUFydT instanceof EntityEnclosingMethod && axeOFxRy != null) {
			if (axeOFxRy instanceof InputStream) {
				RequestEntity mZEVjqjg = new InputStreamRequestEntity((InputStream) axeOFxRy);
				((EntityEnclosingMethod) PFrUFydT).setRequestEntity(mZEVjqjg);
			} else {
				RequestEntity tdkykbPM = new StringRequestEntity(axeOFxRy.toString(), eGxQ0Zrh, null);
				((EntityEnclosingMethod) PFrUFydT).setRequestEntity(tdkykbPM);
			}
		}
		HttpClient FhAn3HoE = new HttpClient(new org.apache.commons.httpclient.SimpleHttpConnectionManager());
		FhAn3HoE.getParams().setBooleanParameter(HttpClientParams.ALLOW_CIRCULAR_REDIRECTS, true);
		InputStream NCCFevRo = null;
		try {
			int Dm2EFCvl = FhAn3HoE.executeMethod(PFrUFydT);
			if (Dm2EFCvl != HttpStatus.SC_OK) {
				LOG.warn("Http Satus:" + Dm2EFCvl + ",Url:" + rIyq16L9);
				if (Dm2EFCvl >= 500 && Dm2EFCvl < 600)
					throw new IOException("Remote service<" + rIyq16L9 + "> respose a error, status:" + Dm2EFCvl);
			}
			NCCFevRo = PFrUFydT.getResponseBodyAsStream();
			IOUtils.copy(NCCFevRo, qCzGZGT6);
		} catch (IOException fl4rbWNk) {
			LOG.error("Failed to access " + rIyq16L9, fl4rbWNk);
			throw fl4rbWNk;
		} finally {
			IOUtils.closeQuietly(NCCFevRo);
			if (PFrUFydT != null)
				PFrUFydT.releaseConnection();
		}
	}

}