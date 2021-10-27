class n22691375 {
	@Override
	protected String getRawPage(String c94ecEcE) throws IOException {
		HttpClient woCqNy5U = new HttpClient();
		String GYamm5Il = config.getString("proxy.host"), D4p9Z6Kq = config.getString("proxy.port");
		if (GYamm5Il != null && D4p9Z6Kq != null) {
			int mwHsFLAg = -1;
			try {
				mwHsFLAg = Integer.parseInt(D4p9Z6Kq);
			} catch (NumberFormatException VNjvyZk9) {
			}
			if (mwHsFLAg != -1) {
				woCqNy5U.getHostConfiguration().setProxy(GYamm5Il, mwHsFLAg);
			}
		}
		GetMethod fBWSoBSL = new GetMethod(c94ecEcE);
		fBWSoBSL.setRequestHeader("Accept-Encoding", "");
		fBWSoBSL.setRequestHeader("User-Agent", "Mozilla/5.0");
		int MEhusLMU;
		if ((MEhusLMU = woCqNy5U.executeMethod(fBWSoBSL)) != HttpStatus.SC_OK) {
			throw new RuntimeException("Unexpected HTTP code: " + MEhusLMU);
		}
		String ZAk4hslJ = null;
		Header POPJ9Tpo = fBWSoBSL.getResponseHeader("Content-Type");
		if (POPJ9Tpo != null) {
			String R6adY3Fw = POPJ9Tpo.toString();
			int S75DmsvS = R6adY3Fw.indexOf("charset=");
			if (S75DmsvS != -1) {
				ZAk4hslJ = R6adY3Fw.substring(S75DmsvS + "charset=".length()).trim();
			}
		}
		boolean nJ8EBEg8 = false;
		Header jKEYgFBd = fBWSoBSL.getResponseHeader("Content-Encoding");
		if (jKEYgFBd != null && jKEYgFBd.getValue().equalsIgnoreCase("gzip")) {
			nJ8EBEg8 = true;
		}
		byte[] z07nTlh5;
		try {
			InputStream HhXZ1hFW = nJ8EBEg8 ? new GZIPInputStream(fBWSoBSL.getResponseBodyAsStream())
					: fBWSoBSL.getResponseBodyAsStream();
			ByteArrayOutputStream NNVuZhuF = new ByteArrayOutputStream();
			IOUtils.copy(HhXZ1hFW, NNVuZhuF);
			z07nTlh5 = NNVuZhuF.toByteArray();
			HhXZ1hFW.close();
		} finally {
			fBWSoBSL.releaseConnection();
		}
		if (ZAk4hslJ == null) {
			Matcher EopAZ78C = Pattern.compile("(?i)<meta[^>]*charset=(([^\"]+\")|(\"[^\"]+\"))")
					.matcher(new String(z07nTlh5));
			if (EopAZ78C.find()) {
				ZAk4hslJ = EopAZ78C.group(1).trim().replace("\"", "");
			}
		}
		if (ZAk4hslJ == null) {
			ZAk4hslJ = "UTF-8";
		}
		return new String(z07nTlh5, ZAk4hslJ);
	}

}