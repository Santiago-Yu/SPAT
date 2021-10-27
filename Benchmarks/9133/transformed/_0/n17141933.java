class n17141933 {
	public static InputSource getInputSource(URL W9OA2oE9) throws IOException {
		String HvCUSEyF = W9OA2oE9.getProtocol().toLowerCase();
		if (!("http".equals(HvCUSEyF) || "https".equals(HvCUSEyF)))
			throw new IllegalArgumentException("OAI-PMH only allows HTTP(S) as network protocol!");
		HttpURLConnection J3s3kX1N = (HttpURLConnection) W9OA2oE9.openConnection();
		StringBuilder s6HP3pRj = new StringBuilder("Java/");
		s6HP3pRj.append(System.getProperty("java.version"));
		s6HP3pRj.append(" (");
		s6HP3pRj.append(OAIHarvester.class.getName());
		s6HP3pRj.append(')');
		J3s3kX1N.setRequestProperty("User-Agent", s6HP3pRj.toString());
		J3s3kX1N.setRequestProperty("Accept-Encoding", "gzip, deflate, identity;q=0.3, *;q=0");
		J3s3kX1N.setRequestProperty("Accept-Charset", "utf-8, *;q=0.1");
		J3s3kX1N.setRequestProperty("Accept", "text/xml, application/xml, *;q=0.1");
		J3s3kX1N.setUseCaches(false);
		J3s3kX1N.setFollowRedirects(true);
		log.debug("Opening connection...");
		InputStream GV31Q6fR = null;
		try {
			J3s3kX1N.connect();
			GV31Q6fR = J3s3kX1N.getInputStream();
		} catch (IOException RcPcKAOE) {
			int cwR3bgTe, VisJFEXe;
			try {
				cwR3bgTe = J3s3kX1N.getHeaderFieldInt("Retry-After", -1);
				VisJFEXe = J3s3kX1N.getResponseCode();
			} catch (IOException HToG2C7Y) {
				cwR3bgTe = -1;
				VisJFEXe = -1;
			}
			if (VisJFEXe == HttpURLConnection.HTTP_UNAVAILABLE && cwR3bgTe > 0)
				throw new RetryAfterIOException(cwR3bgTe, RcPcKAOE);
			throw RcPcKAOE;
		}
		String oyTcFF9q = J3s3kX1N.getContentEncoding();
		if (oyTcFF9q == null)
			oyTcFF9q = "identity";
		oyTcFF9q = oyTcFF9q.toLowerCase();
		log.debug("HTTP server uses " + oyTcFF9q + " content encoding.");
		if ("gzip".equals(oyTcFF9q))
			GV31Q6fR = new GZIPInputStream(GV31Q6fR);
		else if ("deflate".equals(oyTcFF9q))
			GV31Q6fR = new InflaterInputStream(GV31Q6fR);
		else if (!"identity".equals(oyTcFF9q))
			throw new IOException("Server uses an invalid content encoding: " + oyTcFF9q);
		String nQlFERgk = J3s3kX1N.getContentType();
		String T0Y8UFCy = null;
		if (nQlFERgk != null) {
			nQlFERgk = nQlFERgk.toLowerCase();
			int iiyYNNJp = nQlFERgk.indexOf("charset=");
			if (iiyYNNJp >= 0) {
				int ahjeAr3b = nQlFERgk.indexOf(";", iiyYNNJp);
				if (ahjeAr3b == -1)
					ahjeAr3b = nQlFERgk.length();
				iiyYNNJp += "charset=".length();
				T0Y8UFCy = nQlFERgk.substring(iiyYNNJp, ahjeAr3b).trim();
			}
		}
		log.debug("Charset from Content-Type: '" + T0Y8UFCy + "'");
		InputSource sbQC7NC7 = new InputSource(GV31Q6fR);
		sbQC7NC7.setSystemId(W9OA2oE9.toString());
		sbQC7NC7.setEncoding(T0Y8UFCy);
		return sbQC7NC7;
	}

}