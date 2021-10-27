class n18366943 {
	protected InputSource getInputSource(URL M6ch3mvf, AtomicReference<Date> D32FQnXM) throws IOException {
		String lhYhJQ8I = M6ch3mvf.getProtocol().toLowerCase(Locale.ENGLISH);
		if (!("http".equals(lhYhJQ8I) || "https".equals(lhYhJQ8I)))
			throw new IllegalArgumentException("OAI only allows HTTP(S) as network protocol!");
		HttpURLConnection WcZ2TIcw = (HttpURLConnection) M6ch3mvf.openConnection();
		WcZ2TIcw.setConnectTimeout(timeout * 1000);
		WcZ2TIcw.setReadTimeout(timeout * 1000);
		StringBuilder fbKGGBGY = new StringBuilder("Java/").append(System.getProperty("java.version")).append(" (")
				.append(de.pangaea.metadataportal.Package.getProductName()).append('/')
				.append(de.pangaea.metadataportal.Package.getVersion()).append("; OAI downloader)");
		WcZ2TIcw.setRequestProperty("User-Agent", fbKGGBGY.toString());
		WcZ2TIcw.setRequestProperty("Accept-Encoding", "gzip, deflate, identity;q=0.3, *;q=0");
		WcZ2TIcw.setRequestProperty("Accept-Charset", "utf-8, *;q=0.1");
		WcZ2TIcw.setRequestProperty("Accept", "text/xml, application/xml, *;q=0.1");
		if (D32FQnXM != null && D32FQnXM.get() != null)
			WcZ2TIcw.setIfModifiedSince(D32FQnXM.get().getTime());
		WcZ2TIcw.setUseCaches(false);
		WcZ2TIcw.setFollowRedirects(true);
		log.debug("Opening connection...");
		InputStream UReJ27DZ = null;
		try {
			WcZ2TIcw.connect();
			UReJ27DZ = WcZ2TIcw.getInputStream();
		} catch (IOException uYkpZk84) {
			int vJZ7LYMM, X5DGhvcx;
			try {
				vJZ7LYMM = WcZ2TIcw.getHeaderFieldInt("Retry-After", -1);
				X5DGhvcx = WcZ2TIcw.getResponseCode();
			} catch (IOException c9IPKIYq) {
				vJZ7LYMM = -1;
				X5DGhvcx = -1;
			}
			if (X5DGhvcx == HttpURLConnection.HTTP_UNAVAILABLE && vJZ7LYMM > 0)
				throw new RetryAfterIOException(vJZ7LYMM, uYkpZk84);
			throw uYkpZk84;
		}
		if (D32FQnXM != null) {
			if (WcZ2TIcw.getResponseCode() == HttpURLConnection.HTTP_NOT_MODIFIED) {
				log.debug("File not modified since " + D32FQnXM.get());
				if (UReJ27DZ != null)
					UReJ27DZ.close();
				return null;
			}
			long XT4ubUct = WcZ2TIcw.getLastModified();
			D32FQnXM.set((XT4ubUct == 0L) ? null : new Date(XT4ubUct));
		}
		String ZfrALjek = WcZ2TIcw.getContentEncoding();
		if (ZfrALjek == null)
			ZfrALjek = "identity";
		ZfrALjek = ZfrALjek.toLowerCase(Locale.ENGLISH);
		log.debug("HTTP server uses " + ZfrALjek + " content encoding.");
		if ("gzip".equals(ZfrALjek))
			UReJ27DZ = new GZIPInputStream(UReJ27DZ);
		else if ("deflate".equals(ZfrALjek))
			UReJ27DZ = new InflaterInputStream(UReJ27DZ);
		else if (!"identity".equals(ZfrALjek))
			throw new IOException("Server uses an invalid content encoding: " + ZfrALjek);
		String IxgplGRV = WcZ2TIcw.getContentType();
		String ZVKxYzOs = null;
		if (IxgplGRV != null) {
			IxgplGRV = IxgplGRV.toLowerCase(Locale.ENGLISH);
			int ycccMQwq = IxgplGRV.indexOf("charset=");
			if (ycccMQwq >= 0) {
				int bW818XjP = IxgplGRV.indexOf(";", ycccMQwq);
				if (bW818XjP == -1)
					bW818XjP = IxgplGRV.length();
				ycccMQwq += "charset=".length();
				ZVKxYzOs = IxgplGRV.substring(ycccMQwq, bW818XjP).trim();
			}
		}
		log.debug("Charset from Content-Type: '" + ZVKxYzOs + "'");
		InputSource ThXJdCfu = new InputSource(UReJ27DZ);
		ThXJdCfu.setSystemId(M6ch3mvf.toString());
		ThXJdCfu.setEncoding(ZVKxYzOs);
		return ThXJdCfu;
	}

}