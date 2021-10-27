class n17456433 {
	public static boolean isSameHttpContent(final String FeY7T2FB, final File qvzHY7kX,
			UsernamePasswordCredentials PXKjrto7) throws IOException {
		if (qvzHY7kX.isFile()) {
			long sRoFdH23 = qvzHY7kX.length();
			long AQrhX7iz = qvzHY7kX.lastModified() / 1000;
			long SMpkvtXo = -1;
			long Gs6P9HC2 = -1;
			HttpClient x0luSD1R = createHttpClient(PXKjrto7);
			try {
				HttpHead Rf9Ci4kL = new HttpHead(FeY7T2FB);
				HttpResponse j9lrklVI = x0luSD1R.execute(Rf9Ci4kL);
				if (j9lrklVI != null) {
					StatusLine xaS5gzaM = j9lrklVI.getStatusLine();
					int TKgcZ1WR = xaS5gzaM.getStatusCode() / 100;
					if (TKgcZ1WR == 2) {
						Header lGbp38f6 = j9lrklVI.getFirstHeader("Last-Modified");
						Header AgJ9UFST = j9lrklVI.getFirstHeader("Content-Length");
						if (AgJ9UFST != null) {
							SMpkvtXo = Integer.parseInt(AgJ9UFST.getValue());
						}
						if (lGbp38f6 != null) {
							SimpleDateFormat lNIcyPW3 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
							lNIcyPW3.setDateFormatSymbols(new DateFormatSymbols(Locale.US));
							try {
								Gs6P9HC2 = lNIcyPW3.parse(lGbp38f6.getValue()).getTime() / 1000;
							} catch (ParseException aQAGwwcZ) {
								logger.error(aQAGwwcZ);
							}
						}
					} else {
						return true;
					}
				}
			} finally {
				x0luSD1R.getConnectionManager().shutdown();
			}
			if (logger.isDebugEnabled()) {
				logger.debug("local:" + sRoFdH23 + " " + AQrhX7iz);
				logger.debug("remote:" + SMpkvtXo + " " + Gs6P9HC2);
			}
			if (SMpkvtXo != -1 && sRoFdH23 != SMpkvtXo)
				return false;
			if (Gs6P9HC2 != -1 && Gs6P9HC2 != AQrhX7iz)
				return false;
			if (SMpkvtXo == -1 && Gs6P9HC2 == -1)
				return false;
			return true;
		}
		return false;
	}

}