class n4259286 {
	protected List webservice(URL url, List locations, boolean followRedirect) throws GeoServiceException {
		long start = System.currentTimeMillis();
		int rowCount = 0, hitCount = 0;
		try {
			HttpURLConnection con;
			try {
				con = (HttpURLConnection) url.openConnection();
				try {
					con.getClass().getMethod("setConnectTimeout", new Class[] { Integer.TYPE }).invoke(con,
							new Object[] { TIMEOUT });
				} catch (Throwable t) {
					LOG.info("can't set connection timeout");
				}
				con.setRequestMethod("POST");
				con.setDoOutput(true);
				con.setDoInput(true);
				Writer out = new OutputStreamWriter(con.getOutputStream(), UTF8);
				out.write(HEADER + "\n");
				for (int i = 0; i < locations.size(); i++) {
					if (i > 0)
						out.write("\n");
					out.write(encode((GeoLocation) locations.get(i)));
				}
				out.close();
			} catch (IOException e) {
				throw new GeoServiceException("Accessing GEO Webservice failed", e);
			}
			List rows = new ArrayList();
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), UTF8));
				for (int l = 0; l < locations.size(); l++) {
					String line = in.readLine();
					LOG.finer(line);
					if (line == null)
						break;
					if (l == 0 && followRedirect) {
						try {
							return webservice(new URL(line), locations, false);
						} catch (MalformedURLException e) {
						}
					}
					rowCount += 1;
					List row = new ArrayList();
					if (!line.startsWith("?")) {
						StringTokenizer hits = new StringTokenizer(line, ";");
						while (hits.hasMoreTokens()) {
							GeoLocation hit = decode(hits.nextToken());
							if (hit != null) {
								row.add(hit);
								hitCount += 1;
							}
						}
					}
					rows.add(row);
				}
				in.close();
			} catch (IOException e) {
				throw new GeoServiceException("Reading from GEO Webservice failed", e);
			}
			if (rows.size() < locations.size())
				throw new GeoServiceException(
						"GEO Webservice returned " + rows.size() + " rows for " + locations.size() + " locations");
			return rows;
		} finally {
			long secs = (System.currentTimeMillis() - start) / 1000;
			LOG.fine("query for " + locations.size() + " locations in " + secs + "s resulted in " + rowCount
					+ " rows and " + hitCount + " total hits");
		}
	}

}