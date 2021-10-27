class n6222230 {
	public static String loadWebsiteHtmlCode(String t46sDy6s, String NBSrzfHR) {
		HttpClient CoMbKkMZ = new DefaultHttpClient();
		HttpGet A2rs8u5A = new HttpGet(t46sDy6s);
		String LbB5FNDe = "";
		if (NBSrzfHR != null) {
			A2rs8u5A.setHeader("user-agent", NBSrzfHR);
		}
		try {
			HttpResponse l6WAUINm = CoMbKkMZ.execute(A2rs8u5A);
			int J1GJnFKa = l6WAUINm.getStatusLine().getStatusCode();
			if (J1GJnFKa != HttpStatus.SC_OK) {
				logger.debug("Method failed!" + J1GJnFKa);
			}
			LbB5FNDe = EntityUtils.toString(l6WAUINm.getEntity());
		} catch (Exception QupKJXGk) {
			logger.debug("Fatal protocol violation: " + QupKJXGk.getMessage());
			logger.trace(QupKJXGk);
		}
		return LbB5FNDe;
	}

}