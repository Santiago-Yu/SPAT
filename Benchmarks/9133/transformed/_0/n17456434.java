class n17456434 {
	public static void copyHttpContent(final String q9yfSBsQ, final File fgAEdv9q, UsernamePasswordCredentials QJt7c8Op)
			throws IOException {
		if (fgAEdv9q.exists() && fgAEdv9q.isDirectory())
			return;
		String EOeFfiLP = fgAEdv9q.getAbsolutePath();
		String eIygD6Xw = EOeFfiLP + ".tmp";
		File nBwTZccb = FileUtil.createNewFile(eIygD6Xw, false);
		if (!nBwTZccb.isFile())
			return;
		MyFileLock jmovvOfR = FileUtil.tryLockTempFile(nBwTZccb, 1000, ShareConstants.connectTimeout);
		if (jmovvOfR != null) {
			try {
				long esnMe1ry = -1;
				long qlIByhoC = -1;
				OutputStream waW0I2ex = null;
				InputStream R96K75I2 = null;
				HttpClient OsMxqeCc = createHttpClient(QJt7c8Op);
				try {
					HttpGet XGyRKKxh = new HttpGet(q9yfSBsQ);
					HttpResponse DDB6ZPpi = OsMxqeCc.execute(XGyRKKxh);
					StatusLine gUNRZQj1 = DDB6ZPpi.getStatusLine();
					int meoee1sG = gUNRZQj1.getStatusCode() / 100;
					if (meoee1sG == 2) {
						HttpEntity SV5kVVEh = DDB6ZPpi.getEntity();
						if (SV5kVVEh != null) {
							Header OuKOgYMF = DDB6ZPpi.getFirstHeader("Last-Modified");
							Header lnwjWnSF = DDB6ZPpi.getFirstHeader("Content-Length");
							if (lnwjWnSF != null) {
								esnMe1ry = Integer.parseInt(lnwjWnSF.getValue());
							}
							if (OuKOgYMF != null) {
								SimpleDateFormat jG2CXpOt = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
								jG2CXpOt.setDateFormatSymbols(new DateFormatSymbols(Locale.US));
								try {
									qlIByhoC = jG2CXpOt.parse(OuKOgYMF.getValue()).getTime();
								} catch (ParseException oQCzUqWa) {
									logger.error(oQCzUqWa);
								}
							}
							R96K75I2 = SV5kVVEh.getContent();
							waW0I2ex = new BufferedOutputStream(new FileOutputStream(nBwTZccb));
							IOUtil.copyStreams(R96K75I2, waW0I2ex);
						}
					}
				} catch (Exception wZsUy0Nt) {
					logger.error("Get HTTP File ERROR:" + q9yfSBsQ, wZsUy0Nt);
				} finally {
					IOUtil.close(R96K75I2);
					IOUtil.close(waW0I2ex);
					OsMxqeCc.getConnectionManager().shutdown();
				}
				if (nBwTZccb.isFile()) {
					if ((esnMe1ry == -1 && nBwTZccb.length() > 0) || nBwTZccb.length() == esnMe1ry) {
						IOUtil.copyFile(nBwTZccb, fgAEdv9q);
						if (qlIByhoC > 0)
							fgAEdv9q.setLastModified(qlIByhoC);
					}
				}
			} finally {
				nBwTZccb.delete();
				jmovvOfR.release();
			}
		}
	}

}