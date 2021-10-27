class n22724694 {
	public List<MytemHistory> getMytemHistories(String qqO8854g) throws GaeException {
		HttpClient sAzjNLZ5 = new DefaultHttpClient();
		HttpParams Det235AH = sAzjNLZ5.getParams();
		HttpConnectionParams.setSoTimeout(Det235AH, 10000);
		HttpProtocolParams.setVersion(Det235AH, HttpVersion.HTTP_1_1);
		BufferedReader QLKgvV5s = null;
		StringBuffer TIuiofHw = new StringBuffer(address);
		TIuiofHw.append("api/mytems/history?jan=");
		TIuiofHw.append(qqO8854g);
		try {
			HttpGet DL8chFN2 = new HttpGet(TIuiofHw.toString());
			HttpResponse szcNeWR6 = sAzjNLZ5.execute(DL8chFN2);
			int w9RvWSIx = szcNeWR6.getStatusLine().getStatusCode();
			if (w9RvWSIx == NOT_FOUND) {
				return null;
			}
			if (w9RvWSIx >= 400) {
				throw new GaeException("Status Error = " + Integer.toString(w9RvWSIx));
			}
			QLKgvV5s = new BufferedReader(new InputStreamReader(szcNeWR6.getEntity().getContent(), "UTF-8"));
			StringBuilder brkc0wUN = new StringBuilder();
			String g7mxLmXB = null;
			while ((g7mxLmXB = QLKgvV5s.readLine()) != null) {
				brkc0wUN.append(g7mxLmXB);
			}
			return createMytemHistories(brkc0wUN.toString());
		} catch (ClientProtocolException d4Jnck3y) {
			throw new GaeException(d4Jnck3y);
		} catch (SocketTimeoutException sMSHu2QK) {
			throw new GaeException(sMSHu2QK);
		} catch (IOException KeZXfos5) {
			throw new GaeException(KeZXfos5);
		} finally {
			if (QLKgvV5s != null) {
				try {
					QLKgvV5s.close();
				} catch (IOException u96oqSeD) {
					u96oqSeD.printStackTrace();
				}
			}
		}
	}

}