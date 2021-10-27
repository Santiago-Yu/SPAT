class n4259286 {
	protected List webservice(URL DX1oXHzt, List fK27Xxct, boolean GvKVQPXC) throws GeoServiceException {
		long f8dVKaF2 = System.currentTimeMillis();
		int qTmjHG1N = 0, hUICSi6i = 0;
		try {
			HttpURLConnection VZQWsj7K;
			try {
				VZQWsj7K = (HttpURLConnection) DX1oXHzt.openConnection();
				try {
					VZQWsj7K.getClass().getMethod("setConnectTimeout", new Class[] { Integer.TYPE }).invoke(VZQWsj7K,
							new Object[] { TIMEOUT });
				} catch (Throwable YQw1i5fM) {
					LOG.info("can't set connection timeout");
				}
				VZQWsj7K.setRequestMethod("POST");
				VZQWsj7K.setDoOutput(true);
				VZQWsj7K.setDoInput(true);
				Writer fMGQYycE = new OutputStreamWriter(VZQWsj7K.getOutputStream(), UTF8);
				fMGQYycE.write(HEADER + "\n");
				for (int jwUwleKn = 0; jwUwleKn < fK27Xxct.size(); jwUwleKn++) {
					if (jwUwleKn > 0)
						fMGQYycE.write("\n");
					fMGQYycE.write(encode((GeoLocation) fK27Xxct.get(jwUwleKn)));
				}
				fMGQYycE.close();
			} catch (IOException viQv8m91) {
				throw new GeoServiceException("Accessing GEO Webservice failed", viQv8m91);
			}
			List ofYZd3Jk = new ArrayList();
			try {
				BufferedReader KNCRCOP0 = new BufferedReader(new InputStreamReader(VZQWsj7K.getInputStream(), UTF8));
				for (int qvkSA7xJ = 0; qvkSA7xJ < fK27Xxct.size(); qvkSA7xJ++) {
					String vTwR1Q0X = KNCRCOP0.readLine();
					LOG.finer(vTwR1Q0X);
					if (vTwR1Q0X == null)
						break;
					if (qvkSA7xJ == 0 && GvKVQPXC) {
						try {
							return webservice(new URL(vTwR1Q0X), fK27Xxct, false);
						} catch (MalformedURLException lla7RtCV) {
						}
					}
					qTmjHG1N++;
					List TLpdPD1t = new ArrayList();
					if (!vTwR1Q0X.startsWith("?")) {
						StringTokenizer TUlExKdT = new StringTokenizer(vTwR1Q0X, ";");
						while (TUlExKdT.hasMoreTokens()) {
							GeoLocation Hqn1A5Fy = decode(TUlExKdT.nextToken());
							if (Hqn1A5Fy != null) {
								TLpdPD1t.add(Hqn1A5Fy);
								hUICSi6i++;
							}
						}
					}
					ofYZd3Jk.add(TLpdPD1t);
				}
				KNCRCOP0.close();
			} catch (IOException z5fOvmgn) {
				throw new GeoServiceException("Reading from GEO Webservice failed", z5fOvmgn);
			}
			if (ofYZd3Jk.size() < fK27Xxct.size())
				throw new GeoServiceException(
						"GEO Webservice returned " + ofYZd3Jk.size() + " rows for " + fK27Xxct.size() + " locations");
			return ofYZd3Jk;
		} finally {
			long q3x9tZ8G = (System.currentTimeMillis() - f8dVKaF2) / 1000;
			LOG.fine("query for " + fK27Xxct.size() + " locations in " + q3x9tZ8G + "s resulted in " + qTmjHG1N
					+ " rows and " + hUICSi6i + " total hits");
		}
	}

}